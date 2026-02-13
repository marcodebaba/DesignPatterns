package adapterMode.adapter;

import adapterMode.RegisterChannel;
import adapterMode.ResultMsg;

/**
 *
 * @author：marco.pan
 * @ClassName：IRegisterAdapter
 * @Description：Adaptee（被适配者）= 第三方给你的东西
 * @date: 2026年02月09日 9:29
 */
public interface IRegisterAdapter {
    boolean isSupport(RegisterChannel channel);
    
    /**
    * Description：
    * @param id String
    * @return adapterMode.ResultMsg
    * @author marcopan
    * @date 2026/2/12 10:54
    **/
    ResultMsg register(String id);

}
