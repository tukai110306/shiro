package com.yjxbi.commons.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FtcontractConstants {

	public static int DESCTYPE_PARTNO2MODEL = 1;

	public static int DESCTYPE_NAME_BEFORE_BRAND = 2;

	public static int DESCTYPE_PARTNO_NOSHOW = 4;

	public static final String FTC_NEW = "NEW";

	public static final String FTC_RUNNING = "RUN";

	public static final String FTC_CLOSEED = "CLO";

	public static final String FTC_WAIT_AUDIT = "WAU";

	public static final String PRE_EA = "EA";

	public static final String PRE_EC = "EC";

	public static final String PRE_EH = "EH";

	public static final String PRE_EX = "EX";

	public static final String PRE_GX = "GX";

	public static final String PRE_GH = "GH";

	public static final String PRE_WL = "WL";

	public static final String PRE_ET = "ET";

	public static final String PRE_OT = "OT";

	public static final String PRE_IT = "IT";

	public static final String PRE_IL = "IL";

	public static final String PRE_SA = "SA";

	public static final String PRE_SS = "SS";

	public static final String PRE_TE = "TE";

	public static final String PRE_LI = "LI";

	public static final String PRE_TY = "TY";

	public static final String PRE_LG = "LG";
	
	public static final String PRE_OX = "OX";
	
	public static final String PRE_YA = "YA";

	public static final String FTCNO_SYSTEM = "S";

	public static final String FTCNO_CUSTOMER = "C";
	
	public static final String FTC_TRADETERM_CIF = "CIF";

	public static final String FTC_TRADETERM_FOB = "FOB";

	public static final String SELFAGENT_SELF = "S";

	public static final String SELFAGENT_AGENT = "A";

	public static final String CONTRACT_IMP = "IMP";

	public static final String CONTRACT_EXP = "EXP";

	public static final String CONTRACT_TRS = "TRS";

	public static final String CONTRACT_SAL = "SAL";

	public static final String CONTRACT_OTHER = "OTH";


	public static final String CUSTOM_YBM = "0110";

	public static final String CUSTOM_SCJ = "10004";

	public static final List REPORTSTATUS = new ArrayList();

	public static final List CONTRACTCUSTOMS = new ArrayList();

	public static final String TYPE_LG = "LG";

	public static final String TYPE_TY = "TY";

	static {

		CONTRACTCUSTOMS.add(CONTRACT_IMP);
		CONTRACTCUSTOMS.add(CONTRACT_EXP);

	}

	static {

		REPORTSTATUS.add(FTC_RUNNING);
		REPORTSTATUS.add(FTC_CLOSEED);

	}

	public static final List BOMFTC = new ArrayList();

	static {

		BOMFTC.add(PRE_SA);
		BOMFTC.add(PRE_SS);

	}
	
	public static Map<String,Map<String,String>> pubConstants = new HashMap<String,Map<String,String>>();

}