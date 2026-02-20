package adapterMode.adapter;

import adapterMode.PassportService;
import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;

import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;

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
        Objects.requireNonNull(id, "id cannot be null");
        return prefix + "@" + id.hashCode();
    }

    /**
     * 校验 id 是否合法，不合法时返回包含错误信息的 Optional
     *
     * @param id 用户 ID
     * @return 校验失败返回 Optional.of(ResultMsg)，成功返回 Optional.empty()
     */
    protected Optional<ResultMsg> validateId(String id) {
        if (!StringUtils.hasText(id)) {
            return Optional.of(new ResultMsg(400, "id不能为空", null));
        }
        return Optional.empty();
    }
}
