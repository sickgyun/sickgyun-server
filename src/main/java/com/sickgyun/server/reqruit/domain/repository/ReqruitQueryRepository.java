package com.sickgyun.server.reqruit.domain.repository;

import java.util.List;

import com.sickgyun.server.reqruit.domain.Reqruit;
import com.sickgyun.server.user.domain.User;

public interface ReqruitQueryRepository {
	List<Reqruit> findWithoutNotInterested(User user, Long size);
}
