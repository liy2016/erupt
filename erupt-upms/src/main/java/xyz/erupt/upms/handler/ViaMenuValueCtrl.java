package xyz.erupt.upms.handler;

import org.springframework.stereotype.Service;
import xyz.erupt.annotation.config.Comment;
import xyz.erupt.annotation.expr.ExprBool;
import xyz.erupt.upms.model.EruptMenu;
import xyz.erupt.upms.service.EruptUserService;

import javax.annotation.Resource;

/**
 * @author YuePeng
 * date 2020/12/28 22:33
 */
@Service
@Comment("通过菜单类型值控制是否显示")
public class ViaMenuValueCtrl implements ExprBool.ExprHandler {

    @Resource
    private EruptUserService eruptUserService;

    @Override
    @Comment("params必填，值为菜单编码")
    public boolean handler(boolean expr, String[] params) {
        if (null == params || params.length == 0) {
            throw new RuntimeException(ViaMenuValueCtrl.class.getSimpleName() + " → params[0] not found");
        }
        EruptMenu eruptMenu = eruptUserService.getEruptMenuByValue(params[0]);
        return null != eruptMenu;
    }

}
