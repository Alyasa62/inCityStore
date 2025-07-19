package com.example.incitystore.Activities.Dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.incitystore.R
import androidx.compose.material.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration


@Composable
@Preview
fun TopBar() {
    val horizontalPadding = 16.dp
    val verticalPadding = 16.dp

    ConstraintLayout(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
        val(blueBox, title1, title2, profile, building, whiteBox) = createRefs()

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(225.dp)
            .background(color = colorResource(R.color.blue))
            .constrainAs(blueBox) {
                top.linkTo(parent.top)
            })
        Image(painter = painterResource(R.drawable.building),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(building) {
                    bottom.linkTo(blueBox.bottom)
                }
        )
        Image(painter = painterResource(R.drawable.profile),
            contentDescription = null,

            modifier = Modifier
                .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                .constrainAs(profile) {
                    top.linkTo(blueBox.top)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "Good Morning",
            modifier = Modifier
                .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                .constrainAs(title1) {
                    top.linkTo(profile.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            color = colorResource(R.color.white),
            fontSize = 20.sp
        )
        Text(
            text = "What are you doing today?",
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.white),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                .constrainAs(title2) {
                    top.linkTo(title1.bottom)
                    bottom.linkTo(whiteBox.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )
        ConstraintLayout(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(100.dp)
                .background(color = colorResource(R.color.white), shape = RoundedCornerShape(10 .dp))
                .constrainAs(whiteBox) {
                    top.linkTo(blueBox.bottom)
                    bottom.linkTo(blueBox.bottom)
                }
                .clip(RoundedCornerShape(10.dp))
        ) {
            val(icon1, icon2, balance, reward, rewardArrow,medalIcon,rewardText, amount,walletIcon, walletText, walletArrow, arrow2, arrow3, line1, line2) = createRefs()


                val horizontalPadding = 16.dp
                val verticalPadding = 16.dp


                Image(
                    painter = painterResource(R.drawable.wallet),
                    contentDescription = "Wallet Icon",
                    modifier = Modifier
                        .constrainAs(walletIcon) {
                            top.linkTo(parent.top, margin = verticalPadding)
                            start.linkTo(parent.start, margin = horizontalPadding)
                        }
                )

                Text(
                    text = "Wallet",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .constrainAs(walletText) {
                            top.linkTo(walletIcon.top)
                            bottom.linkTo(walletIcon.bottom)
                            start.linkTo(walletIcon.end, margin = 8.dp)
                        }
                )

                Image(
                    painter = painterResource(R.drawable.arrow),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .constrainAs(walletArrow) {

                            top.linkTo(walletText.top)
                            bottom.linkTo(walletText.bottom)
                            start.linkTo(walletText.end, margin = horizontalPadding)
                        }
                )


                Image(
                    painter = painterResource(R.drawable.medal),
                    contentDescription = "Medal Icon",
                    modifier = Modifier
                        .constrainAs(medalIcon) {
                            top.linkTo(walletIcon.bottom, margin = verticalPadding)
                            start.linkTo(parent.start, margin = horizontalPadding)
                        }
                )

                Text(
                    text = "Reward",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .constrainAs(rewardText) {
                            top.linkTo(medalIcon.top)
                            bottom.linkTo(medalIcon.bottom)
                            start.linkTo(medalIcon.end, margin = 8.dp)
                        }
                )

                Image(
                    painter = painterResource(R.drawable.arrow),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .constrainAs(rewardArrow) {
                            top.linkTo(rewardText.top)
                            bottom.linkTo(rewardText.bottom)
                            start.linkTo(rewardText.end, margin = horizontalPadding)
                        }
                )

            Box(modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
                .padding(vertical = verticalPadding)
                .background( color = colorResource(R.color.grey))
                .constrainAs(line1) {
                    centerTo(parent)
                }

            )
            Box(Modifier
                .height(1.dp)
                .width(170.dp)
                .padding(horizontal = 16.dp)
                .background(color = colorResource(R.color.grey))
                .constrainAs(line2) {
                    top.linkTo(parent.top, )
                    start.linkTo(parent.start, )
                    bottom.linkTo(parent.bottom, margin = horizontalPadding)
                }

            )

            Text(
                text = "Balance",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = horizontalPadding, top = 32.dp)
                    .constrainAs(balance) {
                        top.linkTo(parent.top)
                        start.linkTo(line1.end)
                    }

            )
            Text(
                text = "250.00 USD",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = horizontalPadding, top = 8.dp)
                    .constrainAs(amount) {
                        top.linkTo(balance.bottom)
                        start.linkTo(balance.start)
                    }

            )
            Image(
                painter = painterResource(R.drawable.arrow),
                contentDescription = "Arrow",
                modifier = Modifier
                    .constrainAs(arrow3) {

                        bottom.linkTo(amount.bottom)
                        start.linkTo(amount.end)
                    }
            )

            }

        }

    }
