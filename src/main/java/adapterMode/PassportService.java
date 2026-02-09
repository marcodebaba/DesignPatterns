package adapterMode;

/**
 * @author：marco.pan
 * @ClassName：PassportService
 * @Description：统一的注册服务
 * @date: 2026年02月09日 9:29
 */
public class PassportService {
    /**
     * Target（目标）= 你要调用的东西
     * Target 不动 — 它是已有系统，适配器存在的意义就是不改它
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg register(String username, String password, String registerChannel) {
        return new ResultMsg(200, "注册成功", new Member(username, password, registerChannel));
    }
}
