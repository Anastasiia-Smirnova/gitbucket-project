
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Create your account")/*2.49*/{_display_(Seq[Any](format.raw/*2.50*/("""
"""),format.raw/*3.1*/("""<div class="content-wrapper main-center">
  <div class="content body">
    <h2>Create your account</h2>
    <form action=""""),_display_(/*6.20*/context/*6.27*/.path),format.raw/*6.32*/("""/register" method="POST" validate="true" autocomplete="off">
      <div class="row">
        <div class="col-md-6">
          <fieldset>
            <label for="userName" class="strong">Username:</label>
            <input type="text" name="userName" id="userName" value="" class="form-control" autofocus/>
            <span id="error-userName" class="error"></span>
          </fieldset>
          <fieldset>
            <label for="password" class="strong">
              Password:
            </label>
            <input type="password" name="password" id="password" class="form-control" value=""/>
            <span id="error-password" class="error"></span>
          </fieldset>
          <fieldset>
            <label for="fullName" class="strong">Full Name:</label>
            <input type="text" name="fullName" id="fullName" class="form-control" value=""/>
            <span id="error-fullName" class="error"></span>
          </fieldset>
          <fieldset>
            <label for="mailAddress" class="strong">Mail Address:</label>
            <input type="text" name="mailAddress" id="mailAddress" class="form-control" value=""/>
            <span id="error-mailAddress" class="error"></span>
          </fieldset>
          <div id="extraMailAddresses">
            <span class="strong">Additional Mail Address:</span>
          </div>
          <fieldset>
            <label for="url" class="strong">URL (optional):</label>
            <input type="text" name="url" id="url" class="form-control" value=""/>
            <span id="error-url" class="error"></span>
          </fieldset>
          <fieldset>
            <label for="description" class="strong">Bio (optional):</label>
            <textarea name="description" id="description" class="form-control"></textarea>
            <span id="error-description" class="error"></span>
          </fieldset>
        </div>
        <div class="col-md-6">
          <fieldset>
            <label for="avatar" class="strong">Image (optional):</label>
            """),_display_(/*48.14*/gitbucket/*48.23*/.core.helper.html.uploadavatar(None)),format.raw/*48.59*/("""
          """),format.raw/*49.11*/("""</fieldset>
        </div>
      </div>
      <fieldset class="border-top">
        <input type="submit" class="btn btn-success" value="Create account"/>
      </fieldset>
    </form>
  </div>
</div>
<script>
  $(function() """),format.raw/*59.16*/("""{"""),format.raw/*59.17*/("""
    """),format.raw/*60.5*/("""addExtraMailAddress();
    $('#extraMailAddresses').on('change', '.extraMailAddress', checkExtraMailAddress);
  """),format.raw/*62.3*/("""}"""),format.raw/*62.4*/(""");
</script>
""")))}),format.raw/*64.2*/("""
"""))
      }
    }
  }

  def render(context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply()(context)

  def f:(() => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = () => (context) => apply()(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/register.scala.html
                  HASH: c6d9e5549d081c7690a5db9a4a32c46743b5a3fd
                  MATRIX: 613->1|762->58|779->67|825->105|863->106|890->107|1039->230|1054->237|1079->242|3130->2266|3148->2275|3205->2311|3244->2322|3496->2546|3525->2547|3557->2552|3696->2664|3724->2665|3768->2679
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|23->6|23->6|23->6|65->48|65->48|65->48|66->49|76->59|76->59|77->60|79->62|79->62|81->64
                  -- GENERATED --
              */
          