package com.zeus.enums;

import lombok.Getter;

/**
 * @Description 流程阶段枚举
 * @Author 元稹
 * @Date 21/12/2018 16:55
 * @Version V1.0
 */
@Getter
public enum ProcessStageEnum {
    InformationCommunicationStage(0, "信息沟通阶段"),
    TechnicalExchangeStage(1, "技术对接阶段"),
    QuotationSigningStage(2, "报价签单阶段"),
    UIDesignStage(3, "UI设计阶段"),
    UIConfirmStage(4, "UI确认阶段"),
    CodeImplementationStage(5, "编码实现阶段"),
    IntegrationTestStage(6, "集成测试阶段"),
    ProjectOnlineStage(7, "项目上线阶段");

    private int stageId;
    private String stageInfo;

    /**
     * @param [stageId,ProcessStageEnum * @return
     * @methodName [stageId, stageInfo]  * @author wangdi
     * @date
     */
    ProcessStageEnum(int stageId, String stageInfo) {
        this.stageId = stageId;
        this.stageInfo = stageInfo;
    }

    /**
     * @Description 根据状态值获取状态枚举
     * @Author 元稹
     * @Date 21/12/2018 17:38
     * @Param [state]
     * @Return com.zeus.enums.ProcessStageEnum
     */
    public static ProcessStageEnum stateOf(int state) {
        for (ProcessStageEnum ProcessStageEnum : values()) {
            if (ProcessStageEnum.getStageId() == state) {
                return ProcessStageEnum;
            }
        }
        return null;
    }
}