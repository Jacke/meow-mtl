package com.olegpy.meow.internal

import cats.{Applicative, Functor, Monad}
import cats.mtl._
import shapeless.LowPriority


private[meow] trait ParentInstances extends ParentInstances1 {
  implicit def monadStateIsMonad[F[_], S](
    implicit LP: LowPriority,
    MS: MonadState[F, S]
  ): Monad[F] = MS.monad
}

private[meow] trait ParentInstances1 extends ParentInstances2 {
  implicit def monadChronicleIsMonad[F[_], S](
    implicit LP: LowPriority,
    MC: MonadChronicle[F, S]
  ): Monad[F] = MC.monad
}

private[meow] trait ParentInstances2 extends ParentInstances3 {
  implicit def applicativeHandleIsApplicative[F[_], S](
    implicit LP: LowPriority,
    AH: ApplicativeHandle[F, S]
  ): Applicative[F] = AH.applicative
}

private[meow] trait ParentInstances3 extends ParentInstances4 {
  implicit def applicativeAskIsApplicative[F[_], S](
    implicit LP: LowPriority,
    AA: ApplicativeAsk[F, S]
  ): Applicative[F] = AA.applicative
}

private[meow] trait ParentInstances4 extends ParentInstances5 {
  implicit def applicativeLocalIsApplicative[F[_], S](
    implicit LP: LowPriority,
    AL: ApplicativeLocal[F, S]
  ): Applicative[F] = AL.applicative
}

private[meow] trait ParentInstances5 extends ParentInstances6 {
  implicit def functorRaiseIsFunctor[F[_], S](
    implicit LP: LowPriority,
    FR: FunctorRaise[F, S]
  ): Functor[F] = FR.functor
}

private[meow] trait ParentInstances6 extends ParentInstances7 {
  implicit def functorTellIsFunctor[F[_], S](
    implicit LP: LowPriority,
    FT: FunctorTell[F, S]
  ): Functor[F] = FT.functor
}

private[meow] trait ParentInstances7 {
  implicit def functorListenIsFunctor[F[_], S](
    implicit LP: LowPriority,
    FL: FunctorListen[F, S]
  ): Functor[F] = FL.functor
}
