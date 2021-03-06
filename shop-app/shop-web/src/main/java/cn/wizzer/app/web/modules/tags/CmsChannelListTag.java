package cn.wizzer.app.web.modules.tags;

import cn.wizzer.app.cms.modules.models.Cms_channel;
import cn.wizzer.app.cms.modules.services.CmsChannelService;
import org.beetl.core.GeneralVarTagBinding;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wizzer on 2017/5/22.
 */
@IocBean(singleton = false)
public class CmsChannelListTag extends GeneralVarTagBinding {
    private final static Log log = Logs.get();
    @Inject
    private CmsChannelService cmsChannelService;

    @Override
    public void render() {
        String parentId = Strings.sNull(this.getAttributeValue("parentId"));
        String parentCode = Strings.sNull(this.getAttributeValue("parentCode"));
        List<Cms_channel> list = cmsChannelService.listChannel(parentId, parentCode);
        for(Cms_channel channel:list) {
            this.binds(channel);
            this.doBodyRender();
        }
    }
}
