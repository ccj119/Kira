/*
 *  Copyright 2018 jd.com
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.yihaodian.architecture.kira.client.internal.impl;

import com.yihaodian.architecture.kira.common.EnvironmentStatusEnum;
import com.yihaodian.architecture.kira.common.iface.IPoolAware;
import com.yihaodian.architecture.kira.common.util.KiraUtil;

public class YHDLocalProcessEnvironment extends ProcessEnvironment implements IPoolAware {

  private static final long serialVersionUID = 1L;

  public YHDLocalProcessEnvironment() {
    super();
  }

  public YHDLocalProcessEnvironment(Integer pid) {
    super(pid);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  @Override
  public EnvironmentStatusEnum getEnvironmentStatus() {
    return EnvironmentStatusEnum.RUNNING;
  }

  @Override
  public String toString() {
    return "YHDLocalProcessEnvironment [pid=" + pid + ", environmentStatus="
        + getEnvironmentStatus() + ", appId=" + getAppId() + "]";
  }

  @Override
  public String getAppId() {
    String appId = KiraUtil.appId();
    return appId;
  }
}