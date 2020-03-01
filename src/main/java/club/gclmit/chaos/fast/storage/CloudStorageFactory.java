package club.gclmit.chaos.fast.storage;

import club.gclmit.chaos.fast.storage.client.AliyunStorageClient;
import club.gclmit.chaos.fast.storage.client.QCloudStorageClient;
import club.gclmit.chaos.fast.storage.client.QiniuStorageClient;
import club.gclmit.chaos.fast.storage.properties.Storage;
import club.gclmit.chaos.fast.storage.properties.StorageServer;
import club.gclmit.chaos.fast.storage.client.UpyunStorageClient;

/**
 * <p>
 *  oss 客户端构造器
 * </p>
 *
 * @author: gclm
 * @date: 2019-10-24 16:53:00
 * @version: V1.0
 * @since JDK1.8
 */
public class CloudStorageFactory {

    /**
     * <p>
     *  根据枚举类型返回相应的云存储对象
     * </p>
     *
     * @summary httpdoc 方法注解
     * @author 孤城落寞
     * @param: storageClient
     * @date 2019/10/24 17:10
     * @return: club.gclmit.chaos.service.CloudStorageService
     * @throws
     */
    public static StorageClient build(Storage storage) {
        if (storage.getType() == StorageServer.ALIYUN.getValue()) {
            return new AliyunStorageClient(storage);
        } else if (storage.getType() == StorageServer.QINIU.getValue()) {
            return new QiniuStorageClient(storage);
        } else if (storage.getType() == StorageServer.QUCLOUD.getValue()) {
            return new QCloudStorageClient(storage);
        } else {
            return new UpyunStorageClient(storage);
        }
    }
}
