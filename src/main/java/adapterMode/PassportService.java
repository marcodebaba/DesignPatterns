package adapterMode;

/**
 * @author：marco.pan
 * @ClassName：PassportService
 * @Description：Target 不动 — 它是已有系统，适配器存在的意义就是不改它
 * @date: 2026年02月09日 9:29
 */
public class PassportService {
    /**
     * @param username String
     * @param password String
     * @return 注册结果 ResultMsg
     */
    public ResultMsg register(String username, String password, RegisterChannel registerChannel) {
        return new ResultMsg(200, "注册成功", new Member(username, password, registerChannel));
    }
}
