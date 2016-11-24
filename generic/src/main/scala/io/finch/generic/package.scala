package io.finch

import shapeless._

package object generic {
  def deriveFromParams[Repr <: HList](implicit
    gen: LabelledGeneric.Aux[A, Repr],
    fp: FromParams[Repr]
  ): Endpoint[A] = fp.endpoint.map(gen.from)
}
