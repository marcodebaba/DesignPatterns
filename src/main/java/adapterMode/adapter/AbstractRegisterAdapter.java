package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.RegisterChannel;

/**
 * 适配器抽象基类，持有 PassportService 并提供通用工具方法
 */
public abstract class AbstractRegisterAdapter implements IRegisterAdapter {

    protected final PassportService passportService;
    private final RegisterChannel channel;

    protected AbstractRegisterAdapter(PassportService passportService, RegisterChannel channel) {
        this.passportService = passportService;
        this.channel = channel;
    }

    @Override
    public boolean isSupport(RegisterChannel channel) {
        return this.channel == channel;
    }

    /**
     * 生成密码：prefix + "@" + id.hashCode()
     */
    protected String generatePassword(String prefix, String id) {
        return prefix + "@" + id.hashCode();
    }
}
