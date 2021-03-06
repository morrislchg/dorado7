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

package com.bstek.dorado.web.resolver;

/**
 * @author Benny Bao (mailto:benny.bao@bstek.com)
 * @since 2011-7-18
 */
public class PageAccessDeniedException extends IllegalAccessException {
	private static final long serialVersionUID = -2047396921354715436L;

	public PageAccessDeniedException(String message) {
		super(message);
	}

	public PageAccessDeniedException(Throwable cause) {
		this(cause.getMessage());
		this.initCause(cause);
	}

	public PageAccessDeniedException(String message, Throwable cause) {
		this(message);
		this.initCause(cause);
	}
}
