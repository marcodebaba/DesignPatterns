package adapterMode.adapter;

import adapterMode.ResultMsg;

/**
 * Adaptee（被适配者）= 第三方给你的东西
 */
public interface IRegisterAdapter {
    boolean support(String channel);

    // 怎么把第三方数据转成 Target 要的格式
    ResultMsg register(String id);
}
