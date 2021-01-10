package com.imooc.utils;

import com.imooc.vo.ResultVO;

/**
 * @author yaojun
 * @create 2021-01-10 14:29
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
    }
    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }
}
