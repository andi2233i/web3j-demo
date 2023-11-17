package com.example.web3jdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.http.HttpService;

@RestController
public class Web3jController {

    private final Web3j web3j;

    public Web3jController() {
        // 初始化 Web3j 客户端
        web3j = Web3j.build(new HttpService("https://interrpc.abeychain.com/"));
    }

    @GetMapping("/block")
    public String getLatestBlockNumber() throws Exception {
        // 获取最新的区块号
        EthBlock.Block latestBlock = web3j.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, false)
                .send().getBlock();
        return "Latest Block Number: " + latestBlock.getNumber();
    }
}