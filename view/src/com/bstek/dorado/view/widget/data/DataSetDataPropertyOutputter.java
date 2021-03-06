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

package com.bstek.dorado.view.widget.data;

import com.bstek.dorado.view.output.DataOutputter;
import com.bstek.dorado.view.output.JsonBuilder;
import com.bstek.dorado.view.output.OutputContext;
import com.bstek.dorado.view.output.VirtualPropertyOutputter;

/**
 * @author Benny Bao (mailto:benny.bao@bstek.com)
 * @since 2010-9-3
 */
public class DataSetDataPropertyOutputter extends DataOutputter implements
		VirtualPropertyOutputter {

	public void output(Object object, String property, OutputContext context)
			throws Exception {
		JsonBuilder jsonBuilder = context.getJsonBuilder();
		DataSet dataSet = (DataSet) object;
		LoadMode loadMode = dataSet.getLoadMode();
		if (LoadMode.preload.equals(loadMode)) {
			Object data = dataSet.getData();

			jsonBuilder.escapeableKey(property);
			outputData(data, context);
		} else if (LoadMode.manual.equals(loadMode)) {
			jsonBuilder.key(property).value(null);
		}
	}
}
