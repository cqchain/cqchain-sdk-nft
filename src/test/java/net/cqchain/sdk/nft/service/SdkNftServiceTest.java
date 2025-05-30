package net.cqchain.sdk.nft.service;

import net.cqchain.sdk.nft.bean.*;
import net.cqchain.sdk.nft.feign.entity.DeployVo;
import net.cqchain.sdk.nft.service.impl.SdkNftServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SdkNftServiceTest {
    // 测试账户1
    private final static String address = "0x01ee2dd6bec3fc544f741ca53db3164345f5af8d";
    private final static String publicKey = "da060b03fe8865683f39ade6868dd51c4c2ccd9e3429e693b8d1898aeec5773d96dd6f1ea9bc22e2066bbd3242cbfdc3a610b45f45f69f3abed13f9b71fa7b04";
    private final static String privateKey = "d85a3e49d0d0beb779d406529e9466493d326290d42275debac7f1c677035579";

    // 测试账户2
    private final static String address2 = "0x6b4f0ac5ab186e605be2b3aace4ef839aa3c9919";
    private final static String publicKey2 = "b69801e4038de4da6b70cfe1d214951fc7d5ede0cf14252fcc25ad0a5d56b750719f7ada3de4d498f2c4a8514b6992e66f367f1ab8adc6ef835efcb5b1c8b553";
    private final static String privateKey2 = "4b33f6d4b4ae5db5473a379b9a99826a25738909ee8f7bfcf3e0bff9e6d33840";

    // 测试账户3
    private final static String address3 = "0x3f9a0880ce3a9b7773e02649da141be792090c51";
    private final static String publicKey3 = "ebda44214896add98fbd05e0dec1d2ab5d94fc0fe267e8cf895b182c78dff25614ed741c2087dd929b75bdc22def5ff022fb8330e35570566ea434b8b876eb08";
    private final static String privateKey3 = "8e6f7cc8dd2ed63d876650734c11687866dbe2476cf527783a1b6d838df2fbbf";

    private final SdkNftService sdkNftService;

    public SdkNftServiceTest() {
        this.sdkNftService = new SdkNftServiceImpl();
    }

    @Test
    public void testDeploy() {
        // 同质化合约
        // 0x35536ef68281e4a503a3a884c59ef098cf95627b
        DeployBo bo = new DeployBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setName("test002");
        bo.setSymbol("test002");
        bo.setHomogeneous(1);
        bo.setPublishCount(100);
        DeployVo vo = sdkNftService.deploy(bo);
        System.out.println(vo);
    }

    @Test
    public void testDeploy2() {
        // 同质化合约，同时更新stock信息
        // 0x922171bdbd5fc1380031539ebada0b014ee875d7
        StockInfoBo stockInfoBo = new StockInfoBo();
        stockInfoBo.setUrl("https://www.example.com/1.png");
        stockInfoBo.setUrlHash("hashxxxxxxxxxxxxxxxxxxxxxxxxx");
        stockInfoBo.setPrice(100L);
        stockInfoBo.setSellStatus(1);

        DeployBo bo = new DeployBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setName("test004");
        bo.setSymbol("test004");
        bo.setHomogeneous(1);
        bo.setPublishCount(100);
        bo.setStockInfo(stockInfoBo);
        DeployVo vo = sdkNftService.deploy(bo);
        System.out.println(vo);
    }

    @Test
    public void testDeploy3() {
        // 非同质化合约
        // 0x7d0103ed146c8b3981ac34a067de40196ea59420
        // 0x5bf03c3cc8d6af5f820a9eb1950b037b3189df43
        DeployBo bo = new DeployBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setName("test005");
        bo.setSymbol("test005");
        bo.setHomogeneous(0);
        bo.setPublishCount(1000);
        DeployVo vo = sdkNftService.deploy(bo);
        System.out.println(vo);
    }

    @Test
    public void testUpdatePublishCount() {
        UpdatePublishCountBo bo = new UpdatePublishCountBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x35536ef68281e4a503a3a884c59ef098cf95627b");
        bo.setPublishCount(8000);
        String txHash = sdkNftService.updatePublishCount(bo);
        System.out.println(txHash);
    }

    @Test
    public void testPublish() {
        // 同质化发行
        // 0x35536ef68281e4a503a3a884c59ef098cf95627b
        // 发行10000份完全没压力
        List<StockInfoBo> stockInfoBoList = new ArrayList<>();
        StockInfoBo stockInfoBo = new StockInfoBo();
        stockInfoBo.setUrl("https://www.example.com/1.png");
        stockInfoBo.setUrlHash("hashxxxxxxxxxxxxxxxxxxxxxxxxx");
        stockInfoBo.setPrice(100L);
        stockInfoBo.setSellStatus(1);
        stockInfoBoList.add(stockInfoBo);

        PublishBo bo = new PublishBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x35536ef68281e4a503a3a884c59ef098cf95627b");
        bo.setHomogeneous(1);
        bo.setPublishCount(1000);
        bo.setStockInfoList(stockInfoBoList);

        String txHash = sdkNftService.publish(bo);
        System.out.println(txHash);
    }

    @Test
    public void testPublish2() {
        // 非同质化发行
        // 0x7d0103ed146c8b3981ac34a067de40196ea59420
        List<StockInfoBo> stockInfoBoList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            String name = i + 1 + ".png";
            StockInfoBo stockInfoBo = new StockInfoBo();
            stockInfoBo.setUrl("https://www.example.com/" + name);
            stockInfoBo.setUrlHash("hashxxxxxxxxxxxxxxxxxxxxxxxxx" + i);
            stockInfoBo.setPrice(100L);
            stockInfoBo.setSellStatus(1);
            stockInfoBoList.add(stockInfoBo);
        }

        PublishBo bo = new PublishBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x7d0103ed146c8b3981ac34a067de40196ea59420");
        bo.setHomogeneous(0);
        bo.setPublishCount(1000);
        bo.setStockInfoList(stockInfoBoList);

        String txHash = sdkNftService.publish(bo);
        System.out.println(txHash);
    }

    @Test
    public void testUpdatePrice() {
        // 同质化：0x35536ef68281e4a503a3a884c59ef098cf95627b
        UpdatePriceBo bo = new UpdatePriceBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x35536ef68281e4a503a3a884c59ef098cf95627b");
        bo.setPrice(2990L);
        String txHash = sdkNftService.updatePrice(bo);
        System.out.println(txHash);
    }

    @Test
    public void testUpdatePrice2() {
        // 非同质化：0x7d0103ed146c8b3981ac34a067de40196ea59420
        UpdatePriceBo bo = new UpdatePriceBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x7d0103ed146c8b3981ac34a067de40196ea59420");
        bo.setPrice(2990L);
        bo.setTokenId(21);
        String txHash = sdkNftService.updatePrice(bo);
        System.out.println(txHash);
    }

    @Test
    public void testUpdateStatus() {
        // 同质化：0x35536ef68281e4a503a3a884c59ef098cf95627b
        UpdateStatusBo bo = new UpdateStatusBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x35536ef68281e4a503a3a884c59ef098cf95627b");
        bo.setSellStatus(2);
        String txHash = sdkNftService.updateStatus(bo);
        System.out.println(txHash);
    }

    @Test
    public void testUpdateStatus2() {
        // 非同质化：0x7d0103ed146c8b3981ac34a067de40196ea59420
        UpdateStatusBo bo = new UpdateStatusBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x7d0103ed146c8b3981ac34a067de40196ea59420");
        bo.setSellStatus(2);
        bo.setTokenId(21);
        String txHash = sdkNftService.updateStatus(bo);
        System.out.println(txHash);
    }

    @Test
    public void testUpdateUrl() {
        // 同质化：0x35536ef68281e4a503a3a884c59ef098cf95627b
        UpdateUrlBo bo = new UpdateUrlBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x35536ef68281e4a503a3a884c59ef098cf95627b");
        bo.setUrl("url://test123456");
        bo.setUrlHash("hash1234456");
        String txHash = sdkNftService.updateUrl(bo);
        System.out.println(txHash);
    }

    @Test
    public void testUpdateUrl2() {
        // 非同质化：0x7d0103ed146c8b3981ac34a067de40196ea59420
        UpdateUrlBo bo = new UpdateUrlBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x7d0103ed146c8b3981ac34a067de40196ea59420");
        bo.setUrl("url://test123456");
        bo.setUrlHash("hash1234456");
        bo.setTokenId(21);
        String txHash = sdkNftService.updateUrl(bo);
        System.out.println(txHash);
    }

    @Test
    public void testTransfer() {
        TransferBo bo = new TransferBo();
        bo.setAddress(address);
        bo.setPublicKey(publicKey);
        bo.setPrivateKey(privateKey);
        bo.setContractAddress("0x7d0103ed146c8b3981ac34a067de40196ea59420");
        bo.setToAddress(address2);
        bo.setTokenId(11);
        String txHash = sdkNftService.transfer(bo);
        System.out.println(txHash);
    }

    @Test
    public void testTransfer2() {
        TransferBo bo = new TransferBo();
        bo.setAddress(address2);
        bo.setPublicKey(publicKey2);
        bo.setPrivateKey(privateKey2);
        bo.setContractAddress("0x7d0103ed146c8b3981ac34a067de40196ea59420");
        bo.setToAddress(address3);
        bo.setTokenId(11);
        String txHash = sdkNftService.transfer(bo);
        System.out.println(txHash);
    }

    @Test
    public void testTransfer3() {
        TransferBo bo = new TransferBo();
        bo.setAddress(address3);
        bo.setPublicKey(publicKey3);
        bo.setPrivateKey(privateKey3);
        bo.setContractAddress("0x7d0103ed146c8b3981ac34a067de40196ea59420");
        bo.setToAddress(address);
        bo.setTokenId(11);
        String txHash = sdkNftService.transfer(bo);
        System.out.println(txHash);
    }
}
