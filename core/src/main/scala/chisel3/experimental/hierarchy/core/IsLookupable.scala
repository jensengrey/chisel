// SPDX-License-Identifier: Apache-2.0

package chisel3.experimental.hierarchy.core
//
//import scala.annotation.implicitNotFound
//import scala.collection.mutable.HashMap
//
trait IsLookupable

//class SimpleLookupable[X] extends Lookupable[X] {
//  type B = X
//  type R = X
//  type D = Lense[X]
//  def apply[H](that: A => B, definition: Definition[A]): R = that(definition.proto)
//  def instanceLookup[A](that:   A => B, instance:   Instance[A]):   C = that(instance.proto)
//  def lenseLookup[A](that:      A => B, lense:   Lense[A]):         D = that(lense.proto)
//}
//
//
//
//
//
//
//
//  implicit def lookupIsHierarchical[B <: IsHierarchical](
//    implicit sourceInfo: SourceInfo,
//    compileOptions:      CompileOptions
//  ) = new Lookupable[B] {
//    type R = Instance[B]
//    def definitionLookup[A](that: A => B, definition: Definition[A]): R = {
//      val ret = that(definition.proto)
//      val proxy = new InstantiableClone[B] {
//        val proto = ret
//        val contexts = definition.contexts
//        lazy val _innerContext = definition
//      }
//      new Instance(Clone(proxy))
//    }
//    def instanceLookup[A](that: A => B, instance: Instance[A]): R = {
//      val ret = that(instance.proto)
//      //println("lookupIsHierarchical,Inst", ret)
//      val proxy = new InstantiableClone[B] {
//        val proto = ret
//        val contexts = instance.contexts
//        lazy val _innerContext = instance
//        override def toString = s"InstantiableClone($ret)"
//      }
//      new Instance(Clone(proxy))
//    }
//  }
//
//  implicit def lookupIsLookupable[B <: IsLookupable](implicit sourceInfo: SourceInfo, compileOptions: CompileOptions) =
//    new SimpleLookupable[B]()
//
//  implicit val lookupInt = new SimpleLookupable[Int]()
//  implicit val lookupByte = new SimpleLookupable[Byte]()
//  implicit val lookupShort = new SimpleLookupable[Short]()
//  implicit val lookupLong = new SimpleLookupable[Long]()
//  implicit val lookupFloat = new SimpleLookupable[Float]()
//  implicit val lookupChar = new SimpleLookupable[Char]()
//  implicit val lookupString = new SimpleLookupable[String]()
//  implicit val lookupBoolean = new SimpleLookupable[Boolean]()
//  implicit val lookupBigInt = new SimpleLookupable[BigInt]()
//
//
//
//  implicit def lookupContextual[V](
//    implicit sourceInfo: SourceInfo,
//    compileOptions:      CompileOptions,
//    lookupableV:         Lookupable[V],
//  ) = new Lookupable[Contextual[_, V]] {
//    type R = lookupableV.R
//    def instanceLookup[A](that: A => Contextual[_,V], instance: Instance[A]): R = {
//      val value = that(instance.proto).asInstanceOf[Contextual[A,V]].get(instance)
//      //println("lookupC,Inst",value)
//      val ret = lookupableV.instanceLookup({_: A => instance.contexts.apply(value)}, instance)
//      //println("lookupC,Inst,ret",ret)
//      ret
//    }
//    def definitionLookup[A](that: A => Contextual[_,V], definition: Definition[A]): R = {
//      val value = that(definition.proto).asInstanceOf[Contextual[A,V]].get(definition)
//      //println("lookupC,Def",value)
//      val ret = lookupableV.definitionLookup({ _: A => definition.contexts.apply(value) }, definition)
//      //println("lookupC,Def,ret",ret)
//      ret
//    }
//  }
//}
//