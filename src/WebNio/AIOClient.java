package WebNio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class AIOClient {
    public static void main(String[] args) throws Exception {
        final AsynchronousSocketChannel cli = AsynchronousSocketChannel.open();
        cli.connect(new InetSocketAddress("localhost", 8080), null, new CompletionHandler<Void, Object>() {
            @Override
            public void completed(Void result, Object attachment) {
                cli.write(ByteBuffer.wrap("this aysn method".getBytes()), null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        try {
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            cli.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                                @Override
                                public void completed(Integer result, ByteBuffer attachment) {
                                    buffer.flip();
                                    Charset charset = Charset.forName("utf-8");
                                    String msg = charset.decode(buffer).toString();
                                    System.out.println(msg);
                                    try {
                                        cli.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void failed(Throwable exc, ByteBuffer attachment) {

                                }
                            });
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {

                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
            }
        });
        Thread.sleep(1000);
    }
}
