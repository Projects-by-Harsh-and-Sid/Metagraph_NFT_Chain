package com.my.nft.shared_data.deserializers

import com.my.nft.shared_data.types.Types._
import io.circe.Decoder
import io.circe.jawn.decode
import org.tessellation.currency.dataApplication.DataUpdate
import org.tessellation.currency.dataApplication.dataApplication.DataApplicationBlock
import org.tessellation.security.signature.Signed

import java.nio.charset.StandardCharsets

object Deserializers {
  // Helper Functions
  //------------------
  private def deserialize[A: Decoder](bytes: Array[Byte]): Either[Throwable, A] = {
    decode[A](new String(bytes, StandardCharsets.UTF_8))
  }

  // Update Deserialization
  //------------------------
  def deserializeUpdate(bytes: Array[Byte]): Either[Throwable, NFTUpdate] = {
    deserialize[NFTUpdate](bytes)
  }

  // State Deserialization
  //-----------------------
  def deserializeState(bytes: Array[Byte]): Either[Throwable, NFTUpdatesState] = {
    deserialize[NFTUpdatesState](bytes)
  }

  def deserializeCalculatedState(bytes: Array[Byte]): Either[Throwable, NFTUpdatesCalculatedState] = {
    deserialize[NFTUpdatesCalculatedState](bytes)
  }

  // Block Deserialization
  //-----------------------
  def deserializeBlock(bytes: Array[Byte])(implicit e: Decoder[DataUpdate]): Either[Throwable, Signed[DataApplicationBlock]] = {
    deserialize[Signed[DataApplicationBlock]](bytes)
  }
}