package wagering.eventhandler.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import wagering.event.ActionEvent;
import wagering.eventhandler.EventHandler;
import wagering.eventhandler.EventHandlerRegistry;
import wagering.eventhandler.EventService;
import wagering.util.LoggableService;

public class DefaultEventService extends LoggableService implements EventService {

	@Autowired
	private EventHandlerRegistry eventHandlerRegistry;
	private ExecutorService eventDispatcherExecutor = Executors.newFixedThreadPool(10,
			new CustomizableThreadFactory("EventService"));

	@PostConstruct
	public void init() {
		info("event service is ready");
	}

	@Override
	public CompletableFuture<?> dispatch(ActionEvent event) {
		if (event.isBlocked()) {
			CompletableFuture<?> f = new CompletableFuture<>();
			eventHandlerRegistry.getEventHandlers(event.getClass()).ifPresent(handlers -> {
				handlers.forEach(handler -> handler.dispatch(event));
			});
			f.complete(null);
			return f;
		} else {
			Future<?> future = eventDispatcherExecutor.submit(() -> {
				eventHandlerRegistry.getEventHandlers(event.getClass()).ifPresent(handlers -> {
					handlers.forEach(handler -> handler.dispatch(event));
				});
			});

			return CompletableFuture.supplyAsync(() -> {
				try {
					return future.get();
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			});
		}
	}

	@Override
	public void registerEventHandler(Class<? extends ActionEvent> event, EventHandler eventHandler) {
		eventHandlerRegistry.register(eventHandler);
	}

	@Override
	public Optional<List<EventHandler>> getEventHandlers(Class<? extends ActionEvent> event) {
		return eventHandlerRegistry.getEventHandlers(event);
	}

}
