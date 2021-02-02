package com.github.nange.security.gate.service;

import com.github.nange.security.api.vo.log.LogInfo;

public interface LogService {
    void saveLog(LogInfo info);
}
