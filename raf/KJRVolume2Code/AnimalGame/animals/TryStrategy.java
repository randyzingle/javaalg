package animals;

import java.io.IOException;

public interface TryStrategy
{
	public void tryIt(Game game) throws IOException;
}
