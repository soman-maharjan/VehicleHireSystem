package user;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendingObjectOutputStream extends ObjectOutputStream {

	//AppendingObjectOutputStream removes the header problem when appending to java file
  public AppendingObjectOutputStream(OutputStream out) throws IOException {
    super(out);
  }

  @Override
  protected void writeStreamHeader() throws IOException {
    reset();
  }
}