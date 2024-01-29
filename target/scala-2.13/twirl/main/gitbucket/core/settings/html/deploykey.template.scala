
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object deploykey extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[gitbucket.core.service.RepositoryService.RepositoryInfo,List[gitbucket.core.model.DeployKey],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo, deployKeys: List[gitbucket.core.model.DeployKey])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.ssh.SshUtil
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main("Deploy keys", Some(repository))/*4.59*/{_display_(Seq[Any](format.raw/*4.60*/("""
  """),_display_(/*5.4*/gitbucket/*5.13*/.core.html.menu("settings", repository)/*5.52*/{_display_(Seq[Any](format.raw/*5.53*/("""
    """),_display_(/*6.6*/gitbucket/*6.15*/.core.settings.html.menu("deploykeys", repository)/*6.65*/{_display_(Seq[Any](format.raw/*6.66*/("""
      """),format.raw/*7.7*/("""<div class="panel panel-default">
        <div class="panel-heading strong">Deploy keys</div>
        <div class="panel-body">
          """),_display_(if(deployKeys.isEmpty)/*10.34*/{_display_(Seq[Any](format.raw/*10.35*/("""
            """),format.raw/*11.13*/("""No keys
          """)))} else {null} ),format.raw/*12.12*/("""
          """),_display_(/*13.12*/deployKeys/*13.22*/.zipWithIndex.map/*13.39*/ { case (key, i) =>_display_(Seq[Any](format.raw/*13.58*/("""
            """),_display_(if(i != 0)/*14.24*/{_display_(Seq[Any](format.raw/*14.25*/("""
              """),format.raw/*15.15*/("""<hr>
            """)))} else {null} ),format.raw/*16.14*/("""
          """),format.raw/*17.11*/("""<strong style="line-height: 30px;">"""),_display_(/*17.47*/key/*17.50*/.title),format.raw/*17.56*/("""</strong> ("""),_display_(/*17.68*/SshUtil/*17.75*/.fingerPrint(key.publicKey).getOrElse("Key is invalid.")),format.raw/*17.131*/(""")
          """),_display_(if(key.allowWrite)/*18.30*/{_display_(Seq[Any](format.raw/*18.31*/("""
            """),format.raw/*19.13*/("""<label class="label label-warning">Write access</label>
          """)))} else {null} ),format.raw/*20.12*/("""
          """),format.raw/*21.11*/("""<a href=""""),_display_(/*21.21*/helpers/*21.28*/.url(repository)),format.raw/*21.44*/("""/settings/deploykey/delete/"""),_display_(/*21.72*/key/*21.75*/.deployKeyId),format.raw/*21.87*/("""" class="btn btn-sm btn-danger pull-right">Delete</a>
          """)))}),format.raw/*22.12*/("""
        """),format.raw/*23.9*/("""</div>
      </div>
      <form method="POST" action=""""),_display_(/*25.36*/helpers/*25.43*/.url(repository)),format.raw/*25.59*/("""/settings/deploykey" validate="true" autocomplete="off">
        <div class="panel panel-default">
          <div class="panel-heading strong">Add a deploy key</div>
          <div class="panel-body">
            <fieldset class="form-group">
              <label for="title" class="strong">Title</label>
              <div><span id="error-title" class="error"></span></div>
              <input type="text" name="title" id="title" class="form-control"/>
            </fieldset>
            <fieldset class="form-group">
              <label for="publicKey" class="strong">Key</label>
              <div><span id="error-publicKey" class="error"></span></div>
              <textarea name="publicKey" id="publicKey" class="form-control" style="height: 200px;"></textarea>
            </fieldset>
            <fieldset class="form-group">
              <label>
                <input type="checkbox" name="allowWrite"> Allow write access
              </label>
            </fieldset>
            <input type="submit" class="btn btn-success" value="Add"/>
          </div>
        </div>
      </form>
    """)))}),format.raw/*48.6*/("""
  """)))}),format.raw/*49.4*/("""
""")))}),format.raw/*50.2*/("""
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,deployKeys:List[gitbucket.core.model.DeployKey],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,deployKeys)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,List[gitbucket.core.model.DeployKey]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,deployKeys) => (context) => apply(repository,deployKeys)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/deploykey.scala.html
                  HASH: dcbab2fa7665706db8e788815e4c9e725ef3cd01
                  MATRIX: 708->1|953->175|994->210|1057->246|1074->255|1130->303|1168->304|1197->308|1214->317|1261->356|1299->357|1330->363|1347->372|1405->422|1443->423|1476->430|1663->590|1702->591|1743->604|1806->623|1845->635|1864->645|1890->662|1947->681|1998->705|2037->706|2080->721|2142->739|2181->750|2244->786|2256->789|2283->795|2322->807|2338->814|2416->870|2474->901|2513->902|2554->915|2665->982|2704->993|2741->1003|2757->1010|2794->1026|2849->1054|2861->1057|2894->1069|2990->1134|3026->1143|3108->1198|3124->1205|3161->1221|4296->2326|4330->2330|4362->2332
                  LINES: 14->1|17->2|18->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|23->6|24->7|27->10|27->10|28->11|29->12|30->13|30->13|30->13|30->13|31->14|31->14|32->15|33->16|34->17|34->17|34->17|34->17|34->17|34->17|34->17|35->18|35->18|36->19|37->20|38->21|38->21|38->21|38->21|38->21|38->21|38->21|39->22|40->23|42->25|42->25|42->25|65->48|66->49|67->50
                  -- GENERATED --
              */
          