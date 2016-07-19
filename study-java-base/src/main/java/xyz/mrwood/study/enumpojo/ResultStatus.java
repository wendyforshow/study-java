package xyz.mrwood.study.enumpojo;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.enumpojo
 * 功能：如果想要指定数据的话，就要通过以下这种方式实现
 * 时间：2016-07-19 8:08
 * 作者：Mr.Kiwi
 */
public enum ResultStatus {

    SUCCESS(200),
    ERROR(-200),
    FAILURE(-100);

    private int value = 0;

    ResultStatus(int i) {

        this.value = value;
    }

    public int value(){

        return this.value;
    }

    public static ResultStatus valueOf(int value){

        switch (value){

            case 200:
                return SUCCESS;
            case -200:
                return ERROR;
            case -100:
                return FAILURE;
            default:
                return ERROR;
        }
    }
}
