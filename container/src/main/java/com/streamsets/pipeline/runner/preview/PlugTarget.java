/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.runner.preview;

import com.streamsets.pipeline.api.Batch;
import com.streamsets.pipeline.api.Record;
import com.streamsets.pipeline.api.StageException;
import com.streamsets.pipeline.api.base.BaseTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class PlugTarget extends BaseTarget {
  private final Logger LOG = LoggerFactory.getLogger(PlugTarget.class);

  @Override
  public void write(Batch batch) throws StageException {
    String offset = batch.getSourceOffset();
    LOG.debug("Target '{}', writing batch '{}'", getInfo().getInstanceName(), offset);
    Iterator<Record> it = batch.getRecords();
    while (it.hasNext()) {
      LOG.debug("Writing record '{}'", it.next().getHeader().getRecordSourceId());
    }
  }

}
