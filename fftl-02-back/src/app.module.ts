import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { AuthModule } from './auth/auth.module';
import { UserModule } from './user/user.module';
import { BoardModule } from './board/board.module';

@Module({
  imports: [AuthModule, UserModule, TypeOrmModule.forRoot(), BoardModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
