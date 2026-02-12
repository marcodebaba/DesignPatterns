package adapterMode.facade;

import adapterMode.IRegisterForThirdParty;
import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;
import adapterMode.adapter.IRegisterAdapter;

import java.util.List;

public class RegisterForThirdPartyFacade implements IRegisterForThirdParty {

    private final List<IRegisterAdapter> adapters;

    public RegisterForThirdPartyFacade(List<IRegisterAdapter> adapters) {
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
