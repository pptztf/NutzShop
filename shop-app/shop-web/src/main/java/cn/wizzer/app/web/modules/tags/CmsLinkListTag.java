package cn.wizzer.app.web.modules.tags;

import cn.wizzer.app.cms.modules.models.Cms_link;
import cn.wizzer.app.cms.modules.services.CmsLinkService;
import org.apache.commons.lang3.math.NumberUtils;
import org.beetl.core.GeneralVarTagBinding;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;

import java.util.List;

/**
 * Created by wizzer on 2017/5/22.
 */
@IocBean
public class CmsLinkListTag extends GeneralVarTagBinding {
    @Inject
    private CmsLinkService cmsLinkService;

    @Override
    public void render() {
        String code = Strings.sNull(this.getAttributeValue("code"));
        int size = NumberUtils.toInt(Strings.sNull(this.getAttributeValue("size")), 1);
        List<Cms_link> list = cmsLinkService.getLinkList(code, size);
        list.forEach(link -> {
            this.binds(link);
            this.doBodyRender();
        });
    }
}
