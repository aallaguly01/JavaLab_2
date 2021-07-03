package ru.itis.api.redis.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import ru.itis.api.redis.models.RedisUser;

public interface RedisUsersRepository extends KeyValueRepository<RedisUser, String> {
}
