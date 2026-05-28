package org.xyp.project.todoappjpajdbc

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionalOp {
    @Transactional(rollbackFor = [Exception::class], propagation = Propagation.REQUIRED)
    fun runInTransaction(runnable: () -> Unit) {
        runnable()
    }

    @Transactional(rollbackFor = [Exception::class], propagation = Propagation.REQUIRED)
    fun <T> returnInTransaction(supplier: () -> T): T {
        return supplier()
    }
}