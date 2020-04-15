// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragment_type_coercion

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class TestQuery : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = parse(Buffer().write(byteString), scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> = parse(byteString, DEFAULT)

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString =
      OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = scalarTypeAdapters
  )

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  interface FooFoo {
    fun marshaller(): ResponseFieldMarshaller
  }

  data class AsBar(
    val __typename: String = "Bar",
    val foo: String,
    val bar: String
  ) : FooFoo {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@AsBar.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@AsBar.foo)
      writer.writeString(RESPONSE_FIELDS[2], this@AsBar.bar)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("foo", "foo", null, false, null),
          ResponseField.forString("bar", "bar", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): AsBar = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val foo = readString(RESPONSE_FIELDS[1])!!
        val bar = readString(RESPONSE_FIELDS[2])!!
        AsBar(
          __typename = __typename,
          foo = foo,
          bar = bar
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<AsBar> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Foo(
    val __typename: String = "Foo",
    val foo: String,
    val asBar: AsBar?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Foo.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Foo.foo)
      writer.writeFragment(this@Foo.asBar?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("foo", "foo", null, false, null),
          ResponseField.forFragment("__typename", "__typename", listOf(
            ResponseField.Condition.typeCondition(arrayOf("BarObject", "FooBar"))
          ))
          )

      operator fun invoke(reader: ResponseReader): Foo = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val foo = readString(RESPONSE_FIELDS[1])!!
        val asBar = readFragment<AsBar>(RESPONSE_FIELDS[2]) { reader ->
          AsBar(reader)
        }
        Foo(
          __typename = __typename,
          foo = foo,
          asBar = asBar
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Foo> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Data(
    /**
     * For testing fragment type coercion
     */
    val foo: Foo?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.foo?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("foo", "foo", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val foo = readObject<Foo>(RESPONSE_FIELDS[0]) { reader ->
          Foo(reader)
        }
        Data(
          foo = foo
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "65c4fd857f5cbd2283f0783a3b3cefd9ead5abb159f5cc20922b0d8e04286662"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  foo {
          |    __typename
          |    foo
          |    ... on Bar {
          |      bar
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}
