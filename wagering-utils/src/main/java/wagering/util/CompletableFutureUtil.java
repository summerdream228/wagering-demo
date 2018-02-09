package wagering.util;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureUtil {

	public static CompletableFuture<?> fail(Throwable e) {
		CompletableFuture<?> f = new CompletableFuture<>();
		f.completeExceptionally(e);
		return f;
	}
	
}
