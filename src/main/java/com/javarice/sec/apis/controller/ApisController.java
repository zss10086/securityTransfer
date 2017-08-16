package com.javarice.sec.apis.controller;


import com.javarice.sec.apis.constant.ErrorCodeEnum;
import com.javarice.sec.apis.constant.TokenStrEnum;
import com.javarice.sec.apis.dto.DataTransferReceiptDTO;
import com.javarice.sec.apis.post.BatchMsgPost;
import com.javarice.sec.apis.post.SingleMsgPost;
import com.javarice.sec.apis.result.BaseResult;
import com.javarice.sec.apis.utils.MD5Util;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouSs
 * @Mail: zhoushengshuai@ufenqi.com
 * @date:2017/8/16 下午3:31
 * @version: 1.0
 **/
@RestController
@RequestMapping("/api")
public class ApisController{

    /**
     *  批量发送 接口
     * @param singleMsgPost
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/sendMsg",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResult sendMsg(@RequestBody SingleMsgPost singleMsgPost) {
        if (singleMsgPost == null) {
            return new BaseResult(null, ErrorCodeEnum.参数为空.getCode(), ErrorCodeEnum.参数为空.getMessage());
        }
        //codeNum 是否为空
        if (singleMsgPost.getCodeNum() == null
                || singleMsgPost.getTransferTime() == null
                || singleMsgPost.getToken() == null
                || singleMsgPost.getDataMD5() == null
                || singleMsgPost.getMessgagePost() == null
                || singleMsgPost.getTotalAmount() == null) {
            return new BaseResult(null, ErrorCodeEnum.参数为空.getCode(), ErrorCodeEnum.参数为空.getMessage());
        }
        // codeNum 是否合法
        if (!TokenStrEnum.contain(singleMsgPost.getCodeNum())) {
            return new BaseResult(null, ErrorCodeEnum.非法参数.getCode(), ErrorCodeEnum.非法参数.getMessage());
        }
        // 根据codeNum得到 本地local secretKey
        String secretKey = TokenStrEnum.getSecretKeyByCodeNum(singleMsgPost.getCodeNum());
        if (secretKey == null || "".equals(secretKey)) {
            return new BaseResult(null, ErrorCodeEnum.非法参数.getCode(), ErrorCodeEnum.非法参数.getMessage());
        }
        // 根据secretKey 和 传输带过来的时间戳 得到本地计算的 MD5校验串儿
        String localMD5Str = MD5Util.getMD5(secretKey + singleMsgPost.getTransferTime().toString());
        // 比较 校验串儿和 传过来的token
        if (!localMD5Str.equals(singleMsgPost.getToken())) {
            return new BaseResult(null, ErrorCodeEnum.非法参数.getCode(), ErrorCodeEnum.非法参数.getMessage());
        }
        String localDataMD5Str = MD5Util.getMD5(singleMsgPost.getMessgagePost().toString());
        // 比较本地计算数据的MD5和传输过来的MD5 是否一致 保证数据传输的完整性
        if ( !localDataMD5Str.equals(singleMsgPost.getDataMD5())) {
            return new BaseResult(null, ErrorCodeEnum.参数丢失.getCode(), ErrorCodeEnum.非法参数.getMessage());
        }
        List<Long> duplicateTradeIdList = new ArrayList();

        List<Long> errorTradeIdList = new ArrayList();

//        List<TaskWaitPost> taskWaitPostList = batchMsgPost.getTaskWaitPostList();
//        for (TaskWaitPost taskWaitPost : taskWaitPostList) {
//            if (taskDataBiz.countByBusAndMerchantNoAndTradeId(taskWaitPost.getMerchantNo(),taskWaitPost.getBusinessNo(),taskWaitPost.getBillId())) {
//                duplicateTradeIdList.add(taskWaitPost.getBillId());
//                continue;
//            }
//            try {
//                taskDataBiz.saveTaskWait(taskWaitPost);
//            } catch (RuntimeException re) {
//                re.printStackTrace();
//                errorTradeIdList.add(taskWaitPost.getBillId());
//            }
//        }
        // 形成回执
        DataTransferReceiptDTO receipt = null;
        if (duplicateTradeIdList.size() == 0 && errorTradeIdList.size() == 0) {
            receipt = new DataTransferReceiptDTO();
        } else {
            receipt = new DataTransferReceiptDTO(ErrorCodeEnum.系统提醒.getCode(),duplicateTradeIdList,errorTradeIdList);
        }

        return new BaseResult(receipt);
    }

    /**
     *  批量发送 接口
     * @param batchMsgPost
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/sendBatch",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResult sendBatch(@RequestBody BatchMsgPost batchMsgPost) {
        if (batchMsgPost == null) {
            return new BaseResult(null, ErrorCodeEnum.参数为空.getCode(), ErrorCodeEnum.参数为空.getMessage());
        }
        //codeNum 是否为空
        if (batchMsgPost.getCodeNum() == null
                || batchMsgPost.getTransferTime() == null
                || batchMsgPost.getToken() == null
                || batchMsgPost.getDataMD5() == null
                || batchMsgPost.getTaskWaitPostList() == null
                || batchMsgPost.getTotalAmount() == null) {
            return new BaseResult(null, ErrorCodeEnum.参数为空.getCode(), ErrorCodeEnum.参数为空.getMessage());
        }
        // codeNum 是否合法
        if (!TokenStrEnum.contain(batchMsgPost.getCodeNum())) {
            return new BaseResult(null, ErrorCodeEnum.非法参数.getCode(), ErrorCodeEnum.非法参数.getMessage());
        }
        // 根据codeNum得到 本地local secretKey
        String secretKey = TokenStrEnum.getSecretKeyByCodeNum(batchMsgPost.getCodeNum());
        if (secretKey == null || "".equals(secretKey)) {
            return new BaseResult(null, ErrorCodeEnum.非法参数.getCode(), ErrorCodeEnum.非法参数.getMessage());
        }
        // 根据secretKey 和 传输带过来的时间戳 得到本地计算的 MD5校验串儿
        String localMD5Str = MD5Util.getMD5(secretKey + batchMsgPost.getTransferTime().toString());
        // 比较 校验串儿和 传过来的token
        if (!localMD5Str.equals(batchMsgPost.getToken())) {
            return new BaseResult(null, ErrorCodeEnum.非法参数.getCode(), ErrorCodeEnum.非法参数.getMessage());
        }
        String localDataMD5Str = MD5Util.getMD5(batchMsgPost.getTaskWaitPostList().toString());
        // 比较本地计算数据的MD5和传输过来的MD5 是否一致 保证数据传输的完整性
        if ( !localDataMD5Str.equals(batchMsgPost.getDataMD5())) {
            return new BaseResult(null, ErrorCodeEnum.参数丢失.getCode(), ErrorCodeEnum.非法参数.getMessage());
        }
        // 检查数据传输的条数是否和指定要传输的条数一致
        if (batchMsgPost.getTotalAmount().intValue()  != batchMsgPost.getTaskWaitPostList().size()) {
            return new BaseResult(null, ErrorCodeEnum.参数丢失.getCode(), ErrorCodeEnum.非法参数.getMessage());
        }

        List<Long> duplicateTradeIdList = new ArrayList();

        List<Long> errorTradeIdList = new ArrayList();

//        List<TaskWaitPost> taskWaitPostList = batchMsgPost.getTaskWaitPostList();
//        for (TaskWaitPost taskWaitPost : taskWaitPostList) {
//            if (taskDataBiz.countByBusAndMerchantNoAndTradeId(taskWaitPost.getMerchantNo(),taskWaitPost.getBusinessNo(),taskWaitPost.getBillId())) {
//                duplicateTradeIdList.add(taskWaitPost.getBillId());
//                continue;
//            }
//            try {
//                taskDataBiz.saveTaskWait(taskWaitPost);
//            } catch (RuntimeException re) {
//                re.printStackTrace();
//                errorTradeIdList.add(taskWaitPost.getBillId());
//            }
//        }
        // 形成回执
        DataTransferReceiptDTO receipt = null;
        if (duplicateTradeIdList.size() == 0 && errorTradeIdList.size() == 0) {
            receipt = new DataTransferReceiptDTO();
        } else {
            receipt = new DataTransferReceiptDTO(ErrorCodeEnum.系统提醒.getCode(),duplicateTradeIdList,errorTradeIdList);
        }

        return new BaseResult(receipt);
    }




}
