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

package com.bstek.dorado.view.config;

import org.apache.commons.lang.StringUtils;

import com.bstek.dorado.config.definition.DefinitionManager;
import com.bstek.dorado.core.bean.Scope;
import com.bstek.dorado.data.config.definition.DataObjectDefinitionUtils;
import com.bstek.dorado.data.config.definition.DataTypeDefinition;
import com.bstek.dorado.data.config.definition.DataTypeDefinitionManager;
import com.bstek.dorado.util.Assert;
import com.bstek.dorado.view.config.definition.ViewConfigDefinition;

/**
 * @author Benny Bao (mailto:benny.bao@bstek.com)
 * @since 2010-12-28
 */
public class PrivateDataTypeDefinitionManager extends DataTypeDefinitionManager {
	private static final String GLOBAL_PREFIX = "global:";

	private String dataObjectIdPrefix;
	private ViewConfigDefinition viewConfigDefinition;

	public PrivateDataTypeDefinitionManager(
			DefinitionManager<DataTypeDefinition> parent) {
		super(parent);
	}

	public String getDataObjectIdPrefix() {
		return dataObjectIdPrefix;
	}

	public void setDataObjectIdPrefix(String dataObjectIdPrefix) {
		this.dataObjectIdPrefix = dataObjectIdPrefix;
	}

	public void setViewConfigDefinition(
			ViewConfigDefinition viewConfigDefinition) {
		this.viewConfigDefinition = viewConfigDefinition;
	}

	public ViewConfigDefinition getViewConfigDefinition() {
		return viewConfigDefinition;
	}

	@Override
	public void registerDefinition(String name, DataTypeDefinition definition) {
		Assert.notEmpty(name);

		String id = definition.getId();
		if (StringUtils.isEmpty(id)) {
			id = name;
		}
		DataObjectDefinitionUtils.setDataTypeId(definition, dataObjectIdPrefix
				+ id);
		definition.setScope(Scope.thread);

		super.registerDefinition(name, definition);
	}

	@Override
	public DataTypeDefinition getDefinition(String name) {
		DataTypeDefinition definition = null;
		if (name.startsWith(GLOBAL_PREFIX)) {
			DefinitionManager<DataTypeDefinition> parent = getParent();
			if (parent != null) {
				definition = parent.getDefinition(name.substring(GLOBAL_PREFIX
						.length()));
			}
		} else {
			definition = super.getDefinition(name);
		}
		return definition;
	}

	public PrivateDataTypeDefinitionManager duplicate() {
		PrivateDataTypeDefinitionManager duplication = new PrivateDataTypeDefinitionManager(
				getParent());
		duplication.setDataObjectIdPrefix(dataObjectIdPrefix);
		duplication.setViewConfigDefinition(viewConfigDefinition);
		duplication.getDefinitions().putAll(getDefinitions());
		return duplication;
	}
}
