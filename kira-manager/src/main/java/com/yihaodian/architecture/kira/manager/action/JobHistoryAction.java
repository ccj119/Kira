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
package com.yihaodian.architecture.kira.manager.action;

import com.yihaodian.architecture.kira.common.KiraCommonUtils;
import com.yihaodian.architecture.kira.manager.criteria.JobHistoryCriteria;
import com.yihaodian.architecture.kira.manager.domain.JobHistoryDetailData;
import com.yihaodian.architecture.kira.manager.service.JobHistoryService;
import com.yihaodian.architecture.kira.manager.util.Utils;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class JobHistoryAction extends BaseAction {

  private static final long serialVersionUID = 1L;

  private JobHistoryCriteria criteria = new JobHistoryCriteria();
  private transient JobHistoryService jobHistoryService;

  public JobHistoryAction() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public JobHistoryCriteria getCriteria() {
    return criteria;
  }

  public void setCriteria(JobHistoryCriteria criteria) {
    this.criteria = criteria;
  }

  public JobHistoryService getJobHistoryService() {
    return jobHistoryService;
  }

  public void setJobHistoryService(JobHistoryService jobHistoryService) {
    this.jobHistoryService = jobHistoryService;
  }

  public String getJobHistoryDetailDataListOnPage() throws Exception {
    List<JobHistoryDetailData> jobHistoryDetailDataList = jobHistoryService
        .getJobHistoryDetailDataListOnPage(criteria);
    Utils.sendHttpResponseForStruts2(criteria, jobHistoryDetailDataList);
    return null;
  }

  public String archiveForJobHistoryData() throws Exception {
    String newTableNameSuffixForArchive = criteria.getNewTableNameSuffixForArchive();
    if (StringUtils.isBlank(newTableNameSuffixForArchive)) {
      throw new RuntimeException("newTableNameSuffixForArchive should not be blank.");
    }
    String startTimeForArchive = criteria.getStartTimeForArchive();
    Date startTime = null;
    if (StringUtils.isNotBlank(startTimeForArchive)) {
      startTime = KiraCommonUtils.getDateFromString(startTimeForArchive, true);
    }

    String endTimeForArchive = criteria.getEndTimeForArchive();
    Date endTime = null;
    if (StringUtils.isNotBlank(endTimeForArchive)) {
      endTime = KiraCommonUtils.getDateFromString(endTimeForArchive, true);
    }

    jobHistoryService.archiveForJobHistoryData(newTableNameSuffixForArchive, startTime, endTime);
    Utils.sendHttpResponseForStruts2(criteria, null);
    return null;
  }

}
