package adapterMode.adapter;

import adapterMode.IRegisterForThirdParty;
import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;

import java.util.List;

public class RegisterForThirdPartyAdapter implements IRegisterForThirdParty {

    private final List<IRegisterAdapter> adapters;

    public RegisterForThirdPartyAdapter(List<IRegisterAdapter> adapters) {
        this.adapters = adapters;
    }

    @Override
    public ResultMsg registerByThird(String id, RegisterChannel channel) {
        for (IRegisterAdapter adapter : adapters) {
            if (adapter.isSupport(channel)) {
                return adapter.register(id);
            }
        }
        return new ResultMsg(400, "不支持的渠道: " + channel, null);
    }
}
