/*
 * This file is part of Dorado 7.x (http://dorado7.bsdn.org).
 * 
 * Copyright (c) 2002-2012 BSTEK Corp. All rights reserved.
 * 
 * This file is dual-licensed under the AGPLv3 (http://www.gnu.org/licenses/agpl-3.0.html) 
 * and BSDN commercial (http://www.bsdn.org/licenses) licenses.
 * 
 * If you are unsure which license is appropriate for your use, please contact the sales department
 * at http://www.bstek.com/contact.
 */

package com.bstek.dorado.data.type;

import org.apache.commons.lang.StringUtils;

/**
 * 用于描述double的数据类型。
 * 
 * @author Benny Bao (mailto:benny.bao@bstek.com)
 * @since Feb 13, 2007
 */
public class PrimitiveDoubleDataType extends DoubleDataType {

	@Override
	public Object fromText(String text) {
		if (StringUtils.isEmpty(text)) {
			return new Double(0);
		}
		return super.fromText(text);
	}

	@Override
	public Object fromObject(Object value) {
		if (value == null) {
			return new Double(0);
		}
		return super.fromObject(value);
	}

}
