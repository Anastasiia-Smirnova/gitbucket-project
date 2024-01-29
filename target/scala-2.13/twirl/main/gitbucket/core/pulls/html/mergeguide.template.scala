
package gitbucket.core.pulls.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object mergeguide extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[gitbucket.core.service.PullRequestService.MergeStatus,gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(status: gitbucket.core.service.PullRequestService.MergeStatus,
  issue: gitbucket.core.model.Issue,
  pullreq: gitbucket.core.model.PullRequest,
  originRepository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  forkedRepository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import gitbucket.core.view.helpers

def /*274.2*/mergeStrategyLabel/*274.20*/(value: String):String = {{
  Map(
    "merge-commit" -> "Create a merge commit",
    "squash"       -> "Squash and merge",
    "rebase"       -> "Rebase and merge"
  )(value)
}};
Seq[Any](format.raw/*7.1*/("""<div class="issue-comment-box" style="background-color: """),_display_(if(status.hasProblem)/*7.79*/{_display_(Seq[Any](format.raw/*7.80*/(""" """),format.raw/*7.81*/("""#fbeed5 """)))}else/*7.94*/{_display_(Seq[Any](format.raw/*7.95*/(""" """),format.raw/*7.96*/("""#d8f5cd """)))}),format.raw/*7.105*/(""";">
  <div class="box-content" style="border: 1px solid """),_display_(if(status.hasProblem)/*8.75*/{_display_(Seq[Any](format.raw/*8.76*/(""" """),format.raw/*8.77*/("""#c09853 """)))}else/*8.90*/{_display_(Seq[Any](format.raw/*8.91*/(""" """),format.raw/*8.92*/("""#95c97e """)))}),format.raw/*8.101*/(""";padding:0">
    <div id="merge-pull-request">
      """),_display_(if(!status.statuses.isEmpty)/*10.36*/{_display_(Seq[Any](format.raw/*10.37*/("""
        """),format.raw/*11.9*/("""<div class="build-statuses">
          """),_display_(/*12.12*/defining(status.commitStateSummary)/*12.47*/{ case (summaryState, summary) =>_display_(Seq[Any](format.raw/*12.80*/("""
            """),format.raw/*13.13*/("""<a class="pull-right" id="toggle-all-checks" href="javascript:void(0);"></a>
            <span class="build-status-icon text-"""),_display_(/*14.50*/{summaryState.name}),format.raw/*14.69*/("""">"""),_display_(/*14.72*/helpers/*14.79*/.commitStateIcon(summaryState)),format.raw/*14.109*/("""</span>
            <strong class="text-"""),_display_(/*15.34*/{summaryState.name}),format.raw/*15.53*/("""">"""),_display_(/*15.56*/helpers/*15.63*/.commitStateText(summaryState, pullreq.commitIdTo)),format.raw/*15.113*/("""</strong>
            <span class="text-"""),_display_(/*16.32*/{summaryState.name}),format.raw/*16.51*/("""">— """),_display_(/*16.56*/summary),format.raw/*16.63*/(""" """),format.raw/*16.64*/("""checks</span>
          """)))}),format.raw/*17.12*/("""
        """),format.raw/*18.9*/("""</div>
        <div class="build-statuses-list" style=""""),_display_(if(status.isAllSuccess)/*19.73*/{_display_(Seq[Any](format.raw/*19.74*/(""" """),format.raw/*19.75*/("""display:none; """)))} else {null} ),format.raw/*19.90*/("""">
          """),_display_(/*20.12*/status/*20.18*/.statusesAndRequired.map/*20.42*/ { case (status, required) =>_display_(Seq[Any](format.raw/*20.71*/("""
            """),format.raw/*21.13*/("""<div class="build-status-item">
              <div class="pull-right">
                """),_display_(if(required)/*23.30*/{_display_(Seq[Any](format.raw/*23.31*/(""" """),format.raw/*23.32*/("""<span class="label label-success">Required</span> """)))} else {null} ),format.raw/*23.83*/("""
                """),_display_(/*24.18*/status/*24.24*/.targetUrl.map/*24.38*/ { url =>_display_(Seq[Any](format.raw/*24.47*/(""" """),format.raw/*24.48*/("""<a href=""""),_display_(/*24.58*/url),format.raw/*24.61*/("""">Details</a> """)))}),format.raw/*24.76*/("""
              """),format.raw/*25.15*/("""</div>
              <span class="build-status-icon text-"""),_display_(/*26.52*/{status.state.name}),format.raw/*26.71*/("""">"""),_display_(/*26.74*/helpers/*26.81*/.commitStateIcon(status.state)),format.raw/*26.111*/("""</span>
              <strong>"""),_display_(/*27.24*/status/*27.30*/.context),format.raw/*27.38*/("""</strong>
              """),_display_(/*28.16*/status/*28.22*/.description.map/*28.38*/ { desc =>_display_(Seq[Any](format.raw/*28.48*/(""" """),format.raw/*28.49*/("""<span class="muted">— """),_display_(/*28.72*/desc),format.raw/*28.76*/("""</span> """)))}),format.raw/*28.85*/("""
            """),format.raw/*29.13*/("""</div>
          """)))}),format.raw/*30.12*/("""
        """),format.raw/*31.9*/("""</div>
      """)))} else {null} ),format.raw/*32.8*/("""
      """),format.raw/*33.7*/("""<div style="padding:15px">
        """),_display_(if(status.hasConflict)/*34.32*/{_display_(Seq[Any](format.raw/*34.33*/("""
          """),format.raw/*35.11*/("""<div class="merge-indicator merge-indicator-alert"><span class="octicon octicon-alert"></span></div>
          <span class="strong">This branch has conflicts that must be resolved</span>
          <div class="small">
            """),_display_(if(status.hasMergePermission)/*38.43*/{_display_(Seq[Any](format.raw/*38.44*/("""
              """),format.raw/*39.15*/("""<a href="#" class="show-command-line">Use the command line</a> to resolve conflicts before continuing.
            """)))}else/*40.20*/{_display_(Seq[Any](format.raw/*40.21*/("""
              """),format.raw/*41.15*/("""Only those with write access to this repository can merge pull requests.
            """)))}),format.raw/*42.14*/("""
          """),format.raw/*43.11*/("""</div>
          <div>
            <hr>
            """),_display_(/*46.14*/status/*46.20*/.conflictMessage.map/*46.40*/ { message =>_display_(Seq[Any](format.raw/*46.53*/(""" """),_display_(/*46.55*/helpers/*46.62*/.markdown(
              markdown         = message,
              repository       = originRepository,
              branch           = originRepository.repository.defaultBranch,
              enableWikiLink   = false,
              enableRefsLink   = true,
              enableLineBreaks = false
            )),format.raw/*53.14*/(""" """)))}),format.raw/*53.16*/("""
          """),format.raw/*54.11*/("""</div>
        """)))}else/*55.16*/{_display_(Seq[Any](format.raw/*55.17*/("""
          """),_display_(if(status.branchIsOutOfDate)/*56.40*/{_display_(Seq[Any](format.raw/*56.41*/("""
            """),_display_(if(status.hasUpdatePermission)/*57.44*/{_display_(Seq[Any](format.raw/*57.45*/("""
              """),format.raw/*58.15*/("""<div class="pull-right">
                <form method="POST" action=""""),_display_(/*59.46*/helpers/*59.53*/.url(originRepository)),format.raw/*59.75*/("""/pull/"""),_display_(/*59.82*/pullreq/*59.89*/.issueId),format.raw/*59.97*/("""/update_branch">
                  <input type="hidden" name="expected_head_oid" value=""""),_display_(/*60.73*/pullreq/*60.80*/.commitIdFrom),format.raw/*60.93*/("""">
                  <button class="btn btn-default""""),_display_(if(!status.canUpdate)/*61.72*/{_display_(Seq[Any](format.raw/*61.73*/(""" """),format.raw/*61.74*/("""disabled="true"""")))} else {null} ),format.raw/*61.90*/(""" """),format.raw/*61.91*/("""id="update-branch-button">Update branch</button>
                </form>
              </div>
            """)))} else {null} ),format.raw/*64.14*/("""
          """),format.raw/*65.11*/("""<div class="merge-indicator merge-indicator-alert"><span class="octicon octicon-alert"></span></div>
          <span class="strong">This branch is out-of-date with the base branch</span>
          <div class="small">
            Merge the latest changes from <code>"""),_display_(/*68.50*/pullreq/*68.57*/.branch),format.raw/*68.64*/("""</code> into this branch.
          </div>
        """)))}else/*70.16*/{_display_(Seq[Any](format.raw/*70.17*/("""
          """),_display_(if(status.hasRequiredStatusProblem)/*71.47*/ {_display_(Seq[Any](format.raw/*71.49*/("""
            """),format.raw/*72.13*/("""<div class="merge-indicator merge-indicator-warning"><span class="octicon octicon-primitive-dot"></span></div>
            <span class="strong">Required statuses must pass before merging.</span>
            <div class="small">
              All required status checks on this pull request must run successfully to enable automatic merging.
            </div>
          """)))}else/*77.18*/{_display_(Seq[Any](format.raw/*77.19*/("""
            """),format.raw/*78.13*/("""<div class="merge-indicator merge-indicator-success"><span class="octicon octicon-check"></span></div>

            """),_display_(if(pullreq.isDraft)/*80.33*/{_display_(Seq[Any](format.raw/*80.34*/("""
              """),format.raw/*81.15*/("""<span class="strong">This pull request is still a work in progress.</span>
              <div class="pull-right">
                <input type="button" class="btn btn-default" value="Ready for review" id="ready-for-review" />
              </div>
              <div class="small">
                Draft pull requests cannot be merged.
              </div>
            """)))}else/*88.20*/{_display_(Seq[Any](format.raw/*88.21*/("""
              """),_display_(if(status.hasMergePermission)/*89.45*/{_display_(Seq[Any](format.raw/*89.46*/("""
                """),format.raw/*90.17*/("""<span class="strong">Merging can be performed automatically.</span>
                <div class="small">
                  Merging can be performed automatically.
                </div>
              """)))}else/*94.22*/{_display_(Seq[Any](format.raw/*94.23*/("""
                """),format.raw/*95.17*/("""<span class="strong">This branch has no conflicts with the base branch.</span>
                <div class="small">
                  Only those with write access to this repository can merge pull requests.
                </div>
              """)))}),format.raw/*99.16*/("""
            """)))}),format.raw/*100.14*/("""
          """)))}),format.raw/*101.12*/("""
        """)))}),format.raw/*102.10*/("""
      """)))}),format.raw/*103.8*/("""
      """),format.raw/*104.7*/("""</div>
      """),_display_(if(status.hasMergePermission)/*105.37*/{_display_(Seq[Any](format.raw/*105.38*/("""
        """),format.raw/*106.9*/("""<div style="padding:15px; border-top:solid 1px #e5e5e5; background:#fafafa">
          <div class="btn-group">
            <input type="button" class="btn """),_display_(if(!status.hasProblem)/*108.68*/{_display_(Seq[Any](format.raw/*108.69*/("""btn-success""")))}else/*108.87*/{_display_(Seq[Any](format.raw/*108.88*/("""btn-default""")))}),format.raw/*108.100*/("""" id="merge-pull-request-button"
                   value=""""),_display_(/*109.28*/mergeStrategyLabel(originRepository.repository.options.defaultMergeOption)),format.raw/*109.102*/(""""
                   """),_display_(if(!status.canMerge || pullreq.isDraft)/*110.60*/{_display_(Seq[Any](format.raw/*110.61*/("""disabled="true"""")))} else {null} ),format.raw/*110.77*/("""/>
            <button id="merge-strategy-btn" class="dropdown-toggle btn """),_display_(if(!status.hasProblem)/*111.95*/{_display_(Seq[Any](format.raw/*111.96*/("""btn-success""")))}else/*111.114*/{_display_(Seq[Any](format.raw/*111.115*/("""btn-default""")))}),format.raw/*111.127*/("""" data-toggle="dropdown"
                    """),_display_(if(!status.canMerge || pullreq.isDraft)/*112.61*/{_display_(Seq[Any](format.raw/*112.62*/(""" """),format.raw/*112.63*/("""disabled="true"""")))} else {null} ),format.raw/*112.79*/(""">
              <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
            """),_display_(/*116.14*/defining(originRepository.repository.options.mergeOptions.split(","))/*116.83*/{ mergeOptions =>_display_(Seq[Any](format.raw/*116.100*/("""
              """),_display_(if(mergeOptions.contains("merge-commit"))/*117.57*/{_display_(Seq[Any](format.raw/*117.58*/("""
                """),format.raw/*118.17*/("""<li>
                  <a href="javascript:void(0);" class="merge-strategy" data-value="merge-commit">
                    <strong>"""),_display_(/*120.30*/mergeStrategyLabel("merge-commit")),format.raw/*120.64*/("""</strong><br>These commits will be added to the base branch via a merge commit.
                  </a>
                </li>
              """)))} else {null} ),format.raw/*123.16*/("""
              """),_display_(if(mergeOptions.contains("squash"))/*124.51*/{_display_(Seq[Any](format.raw/*124.52*/("""
                """),format.raw/*125.17*/("""<li>
                  <a href="javascript:void(0);" class="merge-strategy" data-value="squash">
                    <strong>"""),_display_(/*127.30*/mergeStrategyLabel("squash")),format.raw/*127.58*/("""</strong><br>These commits will be combined into one commit in the base branch.
                  </a>
                </li>
              """)))} else {null} ),format.raw/*130.16*/("""
              """),_display_(if(mergeOptions.contains("rebase"))/*131.51*/{_display_(Seq[Any](format.raw/*131.52*/("""
                """),format.raw/*132.17*/("""<li>
                  <a href="javascript:void(0);" class="merge-strategy" data-value="rebase">
                    <strong>"""),_display_(/*134.30*/mergeStrategyLabel("rebase")),format.raw/*134.58*/("""</strong><br>These commits will be rebased and added to the base branch.
                  </a>
                </li>
              """)))} else {null} ),format.raw/*137.16*/("""
            """)))}),format.raw/*138.14*/("""
            """),format.raw/*139.13*/("""</ul>
          </div>
        &nbsp;&nbsp;You can also merge branches on the <a href="#" class="show-command-line">command line</a>.
          <div id="command-line" style="display: none;margin-top: 15px;">
            <hr />
            """),_display_(if(status.hasConflict)/*144.36*/{_display_(Seq[Any](format.raw/*144.37*/("""
              """),format.raw/*145.15*/("""<span class="strong">Checkout via command line</span>
              <p>
                If you cannot merge a pull request automatically here, you have the option of checking
                it out via command line to resolve conflicts and perform a manual merge.
              </p>
            """)))}else/*150.20*/{_display_(Seq[Any](format.raw/*150.21*/("""
              """),format.raw/*151.15*/("""<span class="strong">Merging via command line</span>
              <p>
                If you do not want to use the merge button or an automatic merge cannot be performed,
                you can perform a manual merge on the command line.
              </p>
            """)))}),format.raw/*156.14*/("""
            """),_display_(/*157.14*/gitbucket/*157.23*/.core.helper.html.copy("repository-url", "repository-url-copy", forkedRepository.httpUrl)/*157.112*/{_display_(Seq[Any](format.raw/*157.113*/("""
              """),format.raw/*158.15*/("""<div class="input-group-btn" data-toggle="buttons">
                <label class="btn btn-sm btn-default active" id="repository-url-http"><input type="radio" checked>HTTP</label>
                """),_display_(if(context.settings.ssh.enabled && context.loginAccount.isDefined)/*160.84*/{_display_(Seq[Any](format.raw/*160.85*/("""
                  """),format.raw/*161.19*/("""<label class="btn btn-sm btn-default" id="repository-url-ssh"><input type="radio">SSH</label>
                """)))} else {null} ),format.raw/*162.18*/("""
              """),format.raw/*163.15*/("""</div>
              <input type="text" class="form-control input-sm" value=""""),_display_(/*164.72*/forkedRepository/*164.88*/.httpUrl),format.raw/*164.96*/("""" id="repository-url" readonly aria-label="repository-url"/>
            """)))}),format.raw/*165.14*/("""
            """),format.raw/*166.13*/("""<div style="margin-top: 10px;">
              <p>
                <span class="strong">Step 1:</span> From your project repository, check out a new branch and test the changes.
              </p>
              """),_display_(/*170.16*/helpers/*170.23*/.pre/*170.27*/ {_display_(Seq[Any](format.raw/*170.29*/("""
                """),format.raw/*171.17*/("""git checkout -b """),_display_(/*171.34*/{pullreq.requestUserName}),format.raw/*171.59*/("""-"""),_display_(/*171.61*/{pullreq.requestBranch}),format.raw/*171.84*/(""" """),_display_(/*171.86*/{pullreq.branch}),format.raw/*171.102*/("""
                """),format.raw/*172.17*/("""git pull """),_display_(/*172.27*/{forkedRepository.httpUrl}),format.raw/*172.53*/(""" """),_display_(/*172.55*/{pullreq.requestBranch}),format.raw/*172.78*/("""
              """)))}),format.raw/*173.16*/("""
            """),format.raw/*174.13*/("""</div>
            <div>
              <p>
                <span class="strong">Step 2:</span> Merge the changes and update on the server.
              </p>
              """),_display_(/*179.16*/helpers/*179.23*/.pre/*179.27*/ {_display_(Seq[Any](format.raw/*179.29*/("""
                """),format.raw/*180.17*/("""git checkout """),_display_(/*180.31*/{pullreq.branch}),format.raw/*180.47*/("""
                """),format.raw/*181.17*/("""git merge --no-ff """),_display_(/*181.36*/{pullreq.requestUserName}),format.raw/*181.61*/("""-"""),_display_(/*181.63*/{pullreq.requestBranch}),format.raw/*181.86*/("""
                """),format.raw/*182.17*/("""git push origin """),_display_(/*182.34*/{pullreq.branch}),format.raw/*182.50*/("""
              """)))}),format.raw/*183.16*/("""
            """),format.raw/*184.13*/("""</div>
          </div>
        </div>
      """)))} else {null} ),format.raw/*187.8*/("""
    """),format.raw/*188.5*/("""</div>
    <div id="confirm-merge-form" style="display: none; padding: 12px;">
      <form method="POST" action=""""),_display_(/*190.36*/helpers/*190.43*/.url(originRepository)),format.raw/*190.65*/("""/pull/"""),_display_(/*190.72*/pullreq/*190.79*/.issueId),format.raw/*190.87*/("""/merge" validate="true">
        <div class="strong">
          Merge pull request #"""),_display_(/*192.32*/issue/*192.37*/.issueId),format.raw/*192.45*/(""" """),format.raw/*192.46*/("""from """),_display_(/*192.52*/{pullreq.requestUserName}),format.raw/*192.77*/("""/"""),_display_(/*192.79*/{pullreq.requestBranch}),format.raw/*192.102*/("""
        """),format.raw/*193.9*/("""</div>
        <span id="error-message" class="error"></span>
        <textarea name="message" style="height: 80px; margin-top: 8px; margin-bottom: 8px;" class="form-control">"""),_display_(/*195.115*/issue/*195.120*/.title),format.raw/*195.126*/("""</textarea>
        <div>
          <div>
            <input type="button" class="btn btn-default" value="Cancel" id="cancel-merge-pull-request"/>
            <input type="submit" class="btn btn-success" value="Confirm merge"/>
            <input type="hidden" name="strategy" value=""""),_display_(/*200.58*/originRepository/*200.74*/.repository.options.defaultMergeOption),format.raw/*200.112*/(""""/>
            <input type="hidden" name="isDraft" value=""""),_display_(/*201.57*/pullreq/*201.64*/.isDraft),format.raw/*201.72*/("""" />
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

<script>

$(function()"""),format.raw/*211.13*/("""{"""),format.raw/*211.14*/("""
  """),format.raw/*212.3*/("""$('#ready-for-review').click(function()"""),format.raw/*212.42*/("""{"""),format.raw/*212.43*/("""
    """),format.raw/*213.5*/("""$.post('"""),_display_(/*213.14*/helpers/*213.21*/.url(originRepository)),format.raw/*213.43*/("""/pull/"""),_display_(/*213.50*/issue/*213.55*/.issueId),format.raw/*213.63*/("""/update_draft', function(data, status)"""),format.raw/*213.101*/("""{"""),format.raw/*213.102*/("""
      """),format.raw/*214.7*/("""location.reload();
    """),format.raw/*215.5*/("""}"""),format.raw/*215.6*/(""")
  """),format.raw/*216.3*/("""}"""),format.raw/*216.4*/(""");
"""),format.raw/*217.1*/("""}"""),format.raw/*217.2*/(""");

$(function()"""),format.raw/*219.13*/("""{"""),format.raw/*219.14*/("""
  """),format.raw/*220.3*/("""$('.show-command-line').click(function()"""),format.raw/*220.43*/("""{"""),format.raw/*220.44*/("""
    """),format.raw/*221.5*/("""$('#command-line').toggle();
    return false;
  """),format.raw/*223.3*/("""}"""),format.raw/*223.4*/(""");
  function setToggleAllChecksLabel()"""),format.raw/*224.37*/("""{"""),format.raw/*224.38*/("""
    """),format.raw/*225.5*/("""$("#toggle-all-checks").text($('.build-statuses-list').is(":visible") ? "Hide all checks" : "Show all checks");
  """),format.raw/*226.3*/("""}"""),format.raw/*226.4*/("""
  """),format.raw/*227.3*/("""setToggleAllChecksLabel();
  $('#toggle-all-checks').click(function()"""),format.raw/*228.43*/("""{"""),format.raw/*228.44*/("""
    """),format.raw/*229.5*/("""$('.build-statuses-list').toggle();
    setToggleAllChecksLabel();
  """),format.raw/*231.3*/("""}"""),format.raw/*231.4*/(""")

  $('#merge-pull-request-button').click(function()"""),format.raw/*233.51*/("""{"""),format.raw/*233.52*/("""
    """),format.raw/*234.5*/("""$('#merge-pull-request').hide();
    $('#confirm-merge-form').show();
  """),format.raw/*236.3*/("""}"""),format.raw/*236.4*/(""");
  $('#cancel-merge-pull-request').click(function()"""),format.raw/*237.51*/("""{"""),format.raw/*237.52*/("""
    """),format.raw/*238.5*/("""$('#merge-pull-request').show();
    $('#confirm-merge-form').hide();
  """),format.raw/*240.3*/("""}"""),format.raw/*240.4*/(""");

  """),_display_(/*242.4*/forkedRepository/*242.20*/.sshUrl.map/*242.31*/ { sshUrl =>_display_(Seq[Any](format.raw/*242.43*/("""
    """),format.raw/*243.5*/("""$('#repository-url-http').click(function(e)"""),format.raw/*243.48*/("""{"""),format.raw/*243.49*/("""
      """),format.raw/*244.7*/("""// Update URL box
      $('#repository-url').val('"""),_display_(/*245.34*/forkedRepository/*245.50*/.httpUrl),format.raw/*245.58*/("""');
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
      // Update command guidance
      $('#merge-command').text($('#merge-command').text().replace(
        '"""),_display_(/*249.11*/sshUrl),format.raw/*249.17*/("""', '"""),_display_(/*249.22*/forkedRepository/*249.38*/.httpUrl),format.raw/*249.46*/("""'
      ));
      $('#merge-command-copy-1').attr('data-clipboard-text', $('#merge-command').text());
    """),format.raw/*252.5*/("""}"""),format.raw/*252.6*/(""");

    $('#repository-url-ssh').click(function(e)"""),format.raw/*254.47*/("""{"""),format.raw/*254.48*/("""
      """),format.raw/*255.7*/("""// Update URL box
      $('#repository-url').val('"""),_display_(/*256.34*/sshUrl),format.raw/*256.40*/("""');
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
      // Update command guidance
      $('#merge-command').text($('#merge-command').text().replace(
        '"""),_display_(/*260.11*/forkedRepository/*260.27*/.httpUrl),format.raw/*260.35*/("""', '"""),_display_(/*260.40*/sshUrl),format.raw/*260.46*/("""'
      ));
      $('#merge-command-copy-1').attr('data-clipboard-text', $('#merge-command').text());
    """),format.raw/*263.5*/("""}"""),format.raw/*263.6*/(""");
  """)))}),format.raw/*264.4*/("""

  """),format.raw/*266.3*/("""$('.merge-strategy').click(function()"""),format.raw/*266.40*/("""{"""),format.raw/*266.41*/("""
    """),format.raw/*267.5*/("""$('input#merge-pull-request-button').val($(this).find('strong').text());
    $('input[name=strategy]').val($(this).data('value'));

  """),format.raw/*270.3*/("""}"""),format.raw/*270.4*/(""");
"""),format.raw/*271.1*/("""}"""),format.raw/*271.2*/(""");
</script>

"""),format.raw/*280.2*/("""
"""))
      }
    }
  }

  def render(status:gitbucket.core.service.PullRequestService.MergeStatus,issue:gitbucket.core.model.Issue,pullreq:gitbucket.core.model.PullRequest,originRepository:gitbucket.core.service.RepositoryService.RepositoryInfo,forkedRepository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(status,issue,pullreq,originRepository,forkedRepository)(context)

  def f:((gitbucket.core.service.PullRequestService.MergeStatus,gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (status,issue,pullreq,originRepository,forkedRepository) => (context) => apply(status,issue,pullreq,originRepository,forkedRepository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/pulls/mergeguide.scala.html
                  HASH: 15cb15e79cf1d5107a1b6838af176b1b8f0c3083
                  MATRIX: 839->1|1264->355|1313->13044|1341->13062|1547->390|1651->468|1689->469|1717->470|1748->483|1786->484|1814->485|1854->494|1958->572|1996->573|2024->574|2055->587|2093->588|2121->589|2161->598|2270->680|2309->681|2345->690|2412->730|2456->765|2527->798|2568->811|2721->937|2761->956|2791->959|2807->966|2859->996|2927->1037|2967->1056|2997->1059|3013->1066|3085->1116|3153->1157|3193->1176|3225->1181|3253->1188|3282->1189|3338->1214|3374->1223|3480->1302|3519->1303|3548->1304|3607->1319|3648->1333|3663->1339|3696->1363|3763->1392|3804->1405|3931->1505|3970->1506|3999->1507|4094->1558|4139->1576|4154->1582|4177->1596|4224->1605|4253->1606|4290->1616|4314->1619|4360->1634|4403->1649|4488->1707|4528->1726|4558->1729|4574->1736|4626->1766|4684->1797|4699->1803|4728->1811|4780->1836|4795->1842|4820->1858|4868->1868|4897->1869|4947->1892|4972->1896|5012->1905|5053->1918|5102->1936|5138->1945|5195->1959|5229->1966|5314->2024|5353->2025|5392->2036|5678->2295|5717->2296|5760->2311|5899->2433|5938->2434|5981->2449|6098->2535|6137->2546|6217->2599|6232->2605|6261->2625|6312->2638|6341->2640|6357->2647|6689->2958|6722->2960|6761->2971|6800->2993|6839->2994|6906->3034|6945->3035|7016->3079|7055->3080|7098->3095|7195->3165|7211->3172|7254->3194|7288->3201|7304->3208|7333->3216|7449->3305|7465->3312|7499->3325|7600->3399|7639->3400|7668->3401|7728->3417|7757->3418|7908->3525|7947->3536|8240->3802|8256->3809|8284->3816|8359->3874|8398->3875|8472->3922|8512->3924|8553->3937|8946->4313|8985->4314|9026->4327|9189->4463|9228->4464|9271->4479|9662->4853|9701->4854|9773->4899|9812->4900|9857->4917|10080->5123|10119->5124|10164->5141|10439->5385|10485->5399|10529->5411|10571->5421|10610->5429|10645->5436|10716->5479|10756->5480|10793->5489|10999->5667|11039->5668|11075->5686|11115->5687|11160->5699|11248->5759|11345->5833|11434->5894|11474->5895|11535->5911|11660->6008|11700->6009|11737->6027|11778->6028|11823->6040|11936->6125|11976->6126|12006->6127|12067->6143|12213->6261|12292->6330|12349->6347|12434->6404|12474->6405|12520->6422|12680->6554|12736->6588|12921->6728|13000->6779|13040->6780|13086->6797|13240->6923|13290->6951|13475->7091|13554->7142|13594->7143|13640->7160|13794->7286|13844->7314|14022->7447|14068->7461|14110->7474|14400->7736|14440->7737|14484->7752|14804->8054|14844->8055|14888->8070|15193->8343|15235->8357|15254->8366|15354->8455|15395->8456|15439->8471|15729->8733|15769->8734|15817->8753|15973->8864|16017->8879|16123->8957|16149->8973|16179->8981|16285->9055|16327->9068|16566->9279|16583->9286|16597->9290|16638->9292|16684->9309|16729->9326|16776->9351|16806->9353|16851->9376|16881->9378|16920->9394|16966->9411|17004->9421|17052->9447|17082->9449|17127->9472|17175->9488|17217->9501|17418->9674|17435->9681|17449->9685|17490->9687|17536->9704|17578->9718|17616->9734|17662->9751|17709->9770|17756->9795|17786->9797|17831->9820|17877->9837|17922->9854|17960->9870|18008->9886|18050->9899|18140->9945|18173->9950|18315->10064|18332->10071|18376->10093|18411->10100|18428->10107|18458->10115|18571->10200|18586->10205|18616->10213|18646->10214|18680->10220|18727->10245|18757->10247|18803->10270|18840->10279|19045->10455|19061->10460|19090->10466|19403->10751|19429->10767|19490->10805|19578->10865|19595->10872|19625->10880|19755->10981|19785->10982|19816->10985|19884->11024|19914->11025|19947->11030|19984->11039|20001->11046|20045->11068|20080->11075|20095->11080|20125->11088|20193->11126|20224->11127|20259->11134|20310->11157|20339->11158|20371->11162|20400->11163|20431->11166|20460->11167|20505->11183|20535->11184|20566->11187|20635->11227|20665->11228|20698->11233|20775->11282|20804->11283|20872->11322|20902->11323|20935->11328|21077->11442|21106->11443|21137->11446|21235->11515|21265->11516|21298->11521|21395->11590|21424->11591|21506->11644|21536->11645|21569->11650|21669->11722|21698->11723|21780->11776|21810->11777|21843->11782|21943->11854|21972->11855|22006->11862|22032->11878|22053->11889|22104->11901|22137->11906|22209->11949|22239->11950|22274->11957|22353->12008|22379->12024|22409->12032|22640->12235|22668->12241|22701->12246|22727->12262|22757->12270|22891->12376|22920->12377|22999->12427|23029->12428|23064->12435|23143->12486|23171->12492|23402->12695|23428->12711|23458->12719|23491->12724|23519->12730|23653->12836|23682->12837|23719->12843|23751->12847|23817->12884|23847->12885|23880->12890|24042->13024|24071->13025|24102->13028|24131->13029|24173->13240
                  LINES: 14->1|21->6|23->274|23->274|30->7|30->7|30->7|30->7|30->7|30->7|30->7|30->7|31->8|31->8|31->8|31->8|31->8|31->8|31->8|33->10|33->10|34->11|35->12|35->12|35->12|36->13|37->14|37->14|37->14|37->14|37->14|38->15|38->15|38->15|38->15|38->15|39->16|39->16|39->16|39->16|39->16|40->17|41->18|42->19|42->19|42->19|42->19|43->20|43->20|43->20|43->20|44->21|46->23|46->23|46->23|46->23|47->24|47->24|47->24|47->24|47->24|47->24|47->24|47->24|48->25|49->26|49->26|49->26|49->26|49->26|50->27|50->27|50->27|51->28|51->28|51->28|51->28|51->28|51->28|51->28|51->28|52->29|53->30|54->31|55->32|56->33|57->34|57->34|58->35|61->38|61->38|62->39|63->40|63->40|64->41|65->42|66->43|69->46|69->46|69->46|69->46|69->46|69->46|76->53|76->53|77->54|78->55|78->55|79->56|79->56|80->57|80->57|81->58|82->59|82->59|82->59|82->59|82->59|82->59|83->60|83->60|83->60|84->61|84->61|84->61|84->61|84->61|87->64|88->65|91->68|91->68|91->68|93->70|93->70|94->71|94->71|95->72|100->77|100->77|101->78|103->80|103->80|104->81|111->88|111->88|112->89|112->89|113->90|117->94|117->94|118->95|122->99|123->100|124->101|125->102|126->103|127->104|128->105|128->105|129->106|131->108|131->108|131->108|131->108|131->108|132->109|132->109|133->110|133->110|133->110|134->111|134->111|134->111|134->111|134->111|135->112|135->112|135->112|135->112|139->116|139->116|139->116|140->117|140->117|141->118|143->120|143->120|146->123|147->124|147->124|148->125|150->127|150->127|153->130|154->131|154->131|155->132|157->134|157->134|160->137|161->138|162->139|167->144|167->144|168->145|173->150|173->150|174->151|179->156|180->157|180->157|180->157|180->157|181->158|183->160|183->160|184->161|185->162|186->163|187->164|187->164|187->164|188->165|189->166|193->170|193->170|193->170|193->170|194->171|194->171|194->171|194->171|194->171|194->171|194->171|195->172|195->172|195->172|195->172|195->172|196->173|197->174|202->179|202->179|202->179|202->179|203->180|203->180|203->180|204->181|204->181|204->181|204->181|204->181|205->182|205->182|205->182|206->183|207->184|210->187|211->188|213->190|213->190|213->190|213->190|213->190|213->190|215->192|215->192|215->192|215->192|215->192|215->192|215->192|215->192|216->193|218->195|218->195|218->195|223->200|223->200|223->200|224->201|224->201|224->201|234->211|234->211|235->212|235->212|235->212|236->213|236->213|236->213|236->213|236->213|236->213|236->213|236->213|236->213|237->214|238->215|238->215|239->216|239->216|240->217|240->217|242->219|242->219|243->220|243->220|243->220|244->221|246->223|246->223|247->224|247->224|248->225|249->226|249->226|250->227|251->228|251->228|252->229|254->231|254->231|256->233|256->233|257->234|259->236|259->236|260->237|260->237|261->238|263->240|263->240|265->242|265->242|265->242|265->242|266->243|266->243|266->243|267->244|268->245|268->245|268->245|272->249|272->249|272->249|272->249|272->249|275->252|275->252|277->254|277->254|278->255|279->256|279->256|283->260|283->260|283->260|283->260|283->260|286->263|286->263|287->264|289->266|289->266|289->266|290->267|293->270|293->270|294->271|294->271|297->280
                  -- GENERATED --
              */
          