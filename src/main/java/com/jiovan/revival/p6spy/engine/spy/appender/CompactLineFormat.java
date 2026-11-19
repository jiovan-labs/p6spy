/*
 * Copyright (c) 2026 Jiovan Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jiovan.revival.p6spy.engine.spy.appender;


import com.p6spy.engine.spy.appender.MessageFormattingStrategy;


/**
 * Compact to single line strategy for p6spy
 *
 * @author David Hsing
 * @see com.p6spy.engine.spy.appender.SingleLineFormat
 */
@SuppressWarnings("unused")
public class CompactLineFormat implements MessageFormattingStrategy {
    private static final String MESSAGE_TEMPLATE = "{connection: %d, elapsed: %d} statement: %s";    // $NON-NLS-1$

    @Override
    public String formatMessage(int connectionId, String currentTime, long executionTime, String category, String effectiveSql, String sql, String url) {
        String compact = (sql == null || sql.isBlank()) ? null : sql.replaceAll("(\\r?\\n|\\t)+", " ").replaceAll("\\s{2,}", " ").trim();    // $NON-NLS-1$ // $NON-NLS-2$
        return String.format(MESSAGE_TEMPLATE, connectionId, executionTime, compact);
    }
}
