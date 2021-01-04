package com.liwanping.kotlin.lambda

import java.util.*

fun main(args: Array<String>) {
    val d  = CompileDetailDO(xx = 1)
    d.name = "df"
    print(d.name)

    print("xxxxxxxxxxxx".take(2))
}


/**
 * The table 编译详情
 */
data class CompileDetailDO(
        var id: Int? = null,
        var des: String? = null,
        var appId: Int? = null,
        var envId: Int? = null,
        var publishId: Int? = null,
        var fileKey: String? = null,
        var dockerImageName: String? = null,
        var createTime: Date? = null,
        var updateTime: Date? = null,

        // logs 编译日志.
        var logs: String? = null,

        var commitId: String? = null,
        var artifactName: String? = null,

        // compileStatus 编译状态。NOT_STARTED：未开始，COMPILING：正在编译，COMPILE_SUCCESS：编译成功，COMPILE_FAILURE：编译失败.
        var compileStatus: String? = null,

        var curTask: Int? = null,

        var commitMessage: String? = null,
        var gitTag: String? = null,
        var commitAuthor: String? = null,
        var md5: String? = null,
        var ext: String? = null,
        var isDeleted: Int? = null,
        val xx: Int
){
    var name: String = "defaultvalue"
        get() = field                     // getter
        set(value) { field = value + "ddddd"}
}
