package neroao.demobox.subreqserver;

import java.io.Serializable;

public class SubscribeResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5677562174635243777L;
	
	private int subReqID;
	private int respCode;
	private String desc;
	public int getSubReqID() {
		return subReqID;
	}
	public void setSubReqID(int subReqID) {
		this.subReqID = subReqID;
	}
	public int getRespCode() {
		return respCode;
	}
	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString(){
		return "SubsribeResp [subReqID="+subReqID+",respCode="+respCode+",desc="+desc+"]";
	}

}
