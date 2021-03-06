package weaver.interfaces.gx.jyl.jtfybx.fyjk;

import java.rmi.RemoteException;
import java.util.Map;

import javax.xml.bind.JAXBException;

import net.jsgx.www.E1D.service.DT_1029_ALL2ERP_ZJYSSF;
import net.jsgx.www.E1D.service.DT_1029_ALL2ERP_ZJYSSF_RETURN;
import net.jsgx.www.E1D.service.SI_1029_ALL2ERP_ZJYSSF_OUTProxy;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.interfaces.gx.jyl.cw.base.CWPublicMethod;
import weaver.interfaces.gx.jyl.jtfybx.model.JTFYBX_FYJKSFModel;
import weaver.interfaces.gx.jyl.util.XMLUtil;
import weaver.interfaces.workflow.action.Action;
import weaver.soa.workflow.request.Property;
import weaver.soa.workflow.request.RequestInfo;

/**
 * 集团费用报销-费用借款-释放
 */
public class JTFYBX_FYJKSFAction extends BaseBean implements Action {

    private CWPublicMethod publicmethod = new CWPublicMethod();

    public String execute(RequestInfo request) {
        String requestid = request.getRequestid();
        //公司代码-值
        String gsdm_value = "";
        //公司代码-字段
        String gsdm_column = "gsdm";
        //资金凭证编号-值
        String zjpzbh_value = "";
        //资金凭证编号-字段
        String zjpzbh_column = "fzjpzh";
        //系统字段-值
        String xtzd_value = "";
        //系统字段-字段
        String xtzd_column = "xtzd";
        //借款金额-值
        String jkje_value = "";
        //借款金额-字段
        String jkje_column = "jkje";
        
        Property[] properties = request.getMainTableInfo().getProperty();// 获取表单主字段信息
        for (int i = 0; i < properties.length; i++) {
            String name = properties[i].getName();// 主字段名称
            String value = Util.null2String(properties[i].getValue());// 主字段对应的值
            if (name.equals(gsdm_column)) {
                gsdm_value = value;
            }
            if (name.equals(zjpzbh_column)) {
                zjpzbh_value = value;
            }
            if (name.equals(xtzd_column)) {
                xtzd_value = value;
            }
            if (name.equals(jkje_column)) {
            	jkje_value = value;
            }
        }
        writeLog("公司代码：" + gsdm_value);
        writeLog("资金凭证编号：" + zjpzbh_value);
        writeLog("借款金额：" + jkje_value);
        
        String xmlstring = "";
        
        JTFYBX_FYJKSFModel model = new JTFYBX_FYJKSFModel(gsdm_value, zjpzbh_value, "Y", jkje_value);
		try {
			xmlstring = XMLUtil.beanToXml(model, JTFYBX_FYJKSFModel.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
        writeLog("集团费用报销-费用借款-释放传入xml参数：" + xmlstring);

        SI_1029_ALL2ERP_ZJYSSF_OUTProxy proxy = new SI_1029_ALL2ERP_ZJYSSF_OUTProxy();
        DT_1029_ALL2ERP_ZJYSSF DT_1029_ALL2ERP_ZJYSSF = new DT_1029_ALL2ERP_ZJYSSF();
        DT_1029_ALL2ERP_ZJYSSF.setOUTPUT(xmlstring);
        DT_1029_ALL2ERP_ZJYSSF.setSYSTEM(xtzd_value); 
        DT_1029_ALL2ERP_ZJYSSF_RETURN DT_1029_ALL2ERP_ZJYSSF_RETURN = null;
        try {
            DT_1029_ALL2ERP_ZJYSSF_RETURN = proxy.SI_1029_ALL2ERP_ZJYSSF_OUT(DT_1029_ALL2ERP_ZJYSSF);
            String returnmessage = DT_1029_ALL2ERP_ZJYSSF_RETURN.getINPUT();
            writeLog("集团费用报销-费用借款-释放返回消息：" + returnmessage);
            Map<String, String> map = publicmethod.readXMLForSF(returnmessage);
            if (null != map && !map.isEmpty()) {
                String type = (String) map.get("TYPE");
                String code = (String) map.get("CODE");
                String message = (String) map.get("MESSAGE");
                if (!"E".equalsIgnoreCase(type)) {
                    publicmethod.updateJTCWFYJKSF(requestid, type, code, message, "JTFYBX_FYJK");
                } else {
                    publicmethod.setFailMessage(request, "failed", "集团费用报销-费用借款-释放失败：TYPE：" + type + " code：" + code + " message：" + message);
                    return SUCCESS;
                }
            }
        } catch (RemoteException e) {
            publicmethod.setFailMessage(request, "failed", "集团费用报销-费用借款-释放接口异常：" + e);
            return SUCCESS;
        }
        return SUCCESS;
    }
}
