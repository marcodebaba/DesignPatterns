package decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        BoardHandler mb = new ColorFilter(new FrameFilter(new PictureBoard()));
        String content = mb.hangUp("picture");
        log.info("{}", content);

        //new BufferedInputStream(new DataInputStream(new FileInputStream("")));
    }
}
