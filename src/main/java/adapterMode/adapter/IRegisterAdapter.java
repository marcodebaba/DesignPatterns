package adapterMode.adapter;

import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;

/**
 * Author：marco.pan
 * ClassName：IRegisterAdapter
 * Description：统一所有适配器的契约
 * Date: 2026年02月09日 9:29
 */
public interface IRegisterAdapter {
    boolean isSupport(RegisterChannel channel);
    
    /**
    * Description：
    * @param id String
    * @return adapterMode.ResultMsg
    * @author marcopan
    * @date 2026/4/20 23:35
    **/
    ResultMsg register(String id);

}
