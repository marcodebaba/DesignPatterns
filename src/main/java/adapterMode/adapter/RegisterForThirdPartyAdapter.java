package adapterMode.adapter;

import adapterMode.IRegisterForThirdParty;
import adapterMode.PassportService;
import adapterMode.ResultMsg;

import java.util.ArrayList;
import java.util.List;

public class RegisterForThirdPartyAdapter implements IRegisterForThirdParty {

    private final List<IRegisterAdapter> adapters = new ArrayList<>();

    public RegisterForThirdPartyAdapter() {
        PassportService passportService = new PassportService();
        adapters.add(new RegisterForQQAdapter(passportService));
        adapters.add(new RegisterForWeChatAdapter(passportService));
        adapters.add(new RegisterForTokenAdapter(passportService));
        adapters.add(new RegisterForAlipayAdapter(passportService));
    }

    @Override
    public ResultMsg registerByThird(String id, String channel) {
        for (IRegisterAdapter adapter : adapters) {
            if (adapter.isSupport(channel)) {
                return adapter.register(id);
            }
        }
        return new ResultMsg(400, "不支持的渠道: " + channel, null);
    }
}
