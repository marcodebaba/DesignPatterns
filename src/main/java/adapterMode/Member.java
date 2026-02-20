package adapterMode;

import lombok.Data;

/**
 * @author：marco.pan
 * @ClassName：Member
 * @Description：
 * @date: 2026年02月09日 9:29
 */
@Data
public class Member {
    private String username;
    private String password;
    private RegisterChannel registerChannel;
    private String mid;
    private String info;

    public Member(String username, String password, RegisterChannel registerChannel) {
        this.username = username;
        this.password = password;
        this.registerChannel = registerChannel;
    }
}
